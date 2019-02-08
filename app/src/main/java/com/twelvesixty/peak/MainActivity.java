package com.twelvesixty.peak;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback, SharedPreferences.OnSharedPreferenceChangeListener {
    DrawerLayout drawer;
    RecyclerView resortList;
    RecyclerView teamList;
    SupportMapFragment mapView;
    double initialLat;
    double initialLong;
    private SharedPreferences preferences;
    private RecyclerView.Adapter resortAdapter;
    private RecyclerView.Adapter teamAdapter;
    private RecyclerView.LayoutManager resortLayoutManager;
    private RecyclerView.LayoutManager teamLayoutManager;
    private GoogleMap map;
    Gson gson = new Gson();
    //Currently here for dev purposes
    boolean isLoggedIn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getSharedPreferences("preferences", 0);

        preferences.registerOnSharedPreferenceChangeListener(this);

        //TODO: Make this check shared prefs for a token instead
        if (!isLoggedIn) {
            setContentView(R.layout.activity_login);

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
        } else {
            setContentView(R.layout.activity_main);

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

            mapView = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            dropWeather();
            dropResorts();

            //Gets the recyclerview and sets it up to include data from DB
            resortList = findViewById(R.id.recycler_nav);
            resortList.setHasFixedSize(true);
            teamList = findViewById(R.id.filteredList);
            teamList.setHasFixedSize(true);

            // use a linear layout manager
            resortLayoutManager = new LinearLayoutManager(this);
            teamLayoutManager = new LinearLayoutManager(this);
            resortList.setLayoutManager(resortLayoutManager);
            teamList.setLayoutManager(teamLayoutManager);

            // specify an adapter (see also next example)
            Resort[] resortData =  gson.fromJson("[\n" +
                    "    {\n" +
                    "        \"id\": 1,\n" +
                    "        \"name\": \"Crystal Mountain Resort\",\n" +
                    "        \"latitude\": 46.92333,\n" +
                    "        \"longitude\": -121.476,\n" +
                    "        \"websiteUrl\": \"www.somewebsite.com\",\n" +
                    "        \"address\": {\n" +
                    "                \"line1\": \"123 Crystal Rd NE\",\n" +
                    "                \"line2\": \"Appt D4\",\n" +
                    "                \"city\": \"City\",\n" +
                    "                \"state\": \"State\",\n" +
                    "                \"zipcode\": 11111\n" +
                    "            },\n" +
                    "        \"teamsList\": [\n" +
                    "            {\n" +
                    "                \"id\": 5,\n" +
                    "                \"name\": \"Team 3-2\",\n" +
                    "                \"description\": \"I need words here so I can see what is happening here and in the thing below so I'm writing lots of words\",\n" +
                    "                \"currentCapacity\": 3,\n" +
                    "                \"capacity\": 4,\n" +
                    "                \"meetDate\": \"12/31/19 12:00AM\",\n" +
                    "                \"resort\": null,\n" +
                    "                \"status\": \"active\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 6,\n" +
                    "                \"name\": \"Team 3-3\",\n" +
                    "                \"description\": \"I need words here so I can see what is happening\",\n" +
                    "                \"currentCapacity\": 2,\n" +
                    "                \"capacity\": 4,\n" +
                    "                \"meetDate\": \"12/16/19 8:00AM\",\n" +
                    "                \"resort\": null,\n" +
                    "                \"status\": \"active\"\n" +
                    "            }\n" +
                    "        ]\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"id\": 2,\n" +
                    "        \"name\": \"Not Crystal Mountain Resort\",\n" +
                    "        \"latitude\": 47.6062,\n" +
                    "        \"longitude\": -122.3321,\n" +
                    "        \"websiteUrl\": \"www.somewebsite.com\",\n" +
                    "        \"address\": {\n" +
                    "                \"line1\": \"123 Not Crystal Rd NE\",\n" +
                    "                \"line2\": \"\",\n" +
                    "                \"city\": \"City\",\n" +
                    "                \"state\": \"State\",\n" +
                    "                \"zipcode\": 222222\n" +
                    "            },\n" +
                    "        \"teamsList\": [\n" +
                    "            {\n" +
                    "                \"id\": 1,\n" +
                    "                \"name\": \"Team 1-2\",\n" +
                    "                \"description\": \"different words\",\n" +
                    "                \"currentCapacity\": 3,\n" +
                    "                \"capacity\": 4,\n" +
                    "                \"meetDate\": \"12/31/19 12:00AM\",\n" +
                    "                \"resort\": null,\n" +
                    "                \"status\": \"active\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 3,\n" +
                    "                \"name\": \"Team 1-3\",\n" +
                    "                \"description\": \"it switched!\",\n" +
                    "                \"currentCapacity\": 2,\n" +
                    "                \"capacity\": 4,\n" +
                    "                \"meetDate\": \"12/16/19 8:00AM\",\n" +
                    "                \"resort\": null,\n" +
                    "                \"status\": \"active\"\n" +
                    "            }\n" +
                    "        ]\n" +
                    "    }\n" +
                    "]", Resort[].class);
            initialLat = resortData[0].getLatitude();
            initialLong = resortData[0].getLongitude();
            resortAdapter = new ResortAdapter(resortData);
            teamAdapter = new TeamAdapterMain(resortData[0].getTeamsList());
            teamList.setAdapter(teamAdapter);
            resortList.setAdapter(resortAdapter);

            TextView resortName = findViewById(R.id.resortName);
            TextView resortAddress = findViewById(R.id.resortAddress);
            TextView resortWebsite = findViewById(R.id.resortWebsite);

            resortName.setText(resortData[0].getName());
            resortAddress.setText(resortData[0].getAddress().toString());
            resortWebsite.setText(resortData[0].getWebsiteUrl());

            mapView.getMapAsync(this);
        }

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

    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        // Add a marker in Sydney, Australia, and move the camera.
        LatLng coords = new LatLng(initialLat, initialLong);
        map.addMarker(new MarkerOptions().position(coords).title("Marker at resort location"));
        map.moveCamera(CameraUpdateFactory.newLatLng(coords));
        map.setMinZoomPreference(8);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (isLoggedIn) {
            getMenuInflater().inflate(R.menu.main, menu);
        }
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

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        LatLng coords = new LatLng(preferences.getFloat("latitude", 0), preferences.getFloat("longitude", 0));
        map.addMarker(new MarkerOptions().position(coords).title("Marker at resort location"));
        map.moveCamera(CameraUpdateFactory.newLatLng(coords));
        map.setMinZoomPreference(8);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.profile) {
            Intent goToProfile = new Intent(this, UserProfileActivty.class);
            startActivity(goToProfile);
        } else if (id == R.id.groups) {
            Intent goToProfile = new Intent(this, MyGroupsActivity.class);
            startActivity(goToProfile);
        }

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
                    findViewById(R.id.resortsInfo).setVisibility(View.GONE);
                   textView.setVisibility(View.VISIBLE);

                }
            }
        });
    }
  
//    Method that creates dropdown for resorts
    public void dropResorts() {
        findViewById(R.id.resortsInfoDrop).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ConstraintLayout resortInfo = findViewById(R.id.resortsInfo);

                if (resortInfo.getVisibility() == View.VISIBLE) {
                    resortInfo.setVisibility(View.GONE);
                }else {
                    findViewById(R.id.weather).setVisibility(View.GONE);
                    resortInfo.setVisibility(View.VISIBLE);


                }
            }
        });
    }



    public void goToSearchActivity(View v) {
        Intent goToSearch = new Intent(this, SearchActivity.class);
        startActivity(goToSearch);
        drawer.closeDrawer(GravityCompat.END);
    }

    public void GoToSignUpActivity(View v) {
        Intent signUpIntent = new Intent(this, Signup.class);
        startActivity(signUpIntent);
    }

    public void goToCreateGroup(View v) {
        Intent goToCreate = new Intent(this, CreateGroupActivity.class);
        startActivity(goToCreate);
    }

    public void performLogin(View v) {
        //TODO: make this do login stuff. Will most likely be get a token from the server, save it in shared prefs, and recreate()
    }
}
