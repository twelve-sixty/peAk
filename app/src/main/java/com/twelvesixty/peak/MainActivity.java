package com.twelvesixty.peak;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.opengl.Visibility;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.MapView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        NavDrawerFragment nav = new NavDrawerFragment();
        ResortDetailFragment content = new ResortDetailFragment();
        RightDrawerFragment rightDrawer = new RightDrawerFragment();

        fragmentTransaction.add(R.id.drawer_layout, content);
        fragmentTransaction.add(R.id.drawer_layout, nav);
        fragmentTransaction.add(R.id.drawer_layout, rightDrawer);
        fragmentTransaction.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //This adds the hamburger for the navigation drawer. Icon can be changed, but rather complicated.
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.getDrawerArrowDrawable().setDirection(DrawerArrowDrawable.ARROW_DIRECTION_RIGHT);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //Sets up a listener for when a navigation item is selected
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        MapView map = findViewById(R.id.mapView);
        dropWeather();
        dropResorts();
        dropGroups();
    }

    //Handles if the back button is pressed while a drawer is currently open
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //If the right hand logo is clicked, open the right hand drawer
        if (id == R.id.action_openRight) {
            drawer.openDrawer(GravityCompat.END);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    Method that creates dropdown for weather
    public void dropWeather() {
        findViewById(R.id.weatherDrop).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.weather);

                if (textView.getVisibility() == View.VISIBLE) {
                    // make textview disappear
                    textView.setVisibility(View.GONE);
                } else {
                    // make textview visible and other dropdown's close
                    findViewById(R.id.Filters).setVisibility(View.GONE);
                    findViewById(R.id.resortsInfo).setVisibility(View.GONE);
                   textView.setVisibility(View.VISIBLE);

                }
            }
        });
    }
  
//    Method that creates dropdown for groups
    public void dropGroups() {
        findViewById(R.id.groupsDrop).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (findViewById(R.id.Filters).getVisibility() == View.VISIBLE){
                    Log.i("testing", "tests");
                    findViewById(R.id.Filters).setVisibility(View.GONE);
                }else{
                    findViewById(R.id.weather).setVisibility(View.GONE);
                    findViewById(R.id.resortsInfo).setVisibility(View.GONE);
                    findViewById(R.id.Filters).setVisibility(View.VISIBLE);
                }
            }
        });
    }
  
//    Method that creates dropdown for resorts
    public void dropResorts() {
        findViewById(R.id.resortsInfoDrop).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TextView textView2 = findViewById(R.id.resortsInfo);

                if (textView2.getVisibility() == View.VISIBLE) {
                    textView2.setVisibility(View.GONE);
                }else {
                    findViewById(R.id.weather).setVisibility(View.GONE);
                    findViewById(R.id.Filters).setVisibility(View.GONE);
                    textView2.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
