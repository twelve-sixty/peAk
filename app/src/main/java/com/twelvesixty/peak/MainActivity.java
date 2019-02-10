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
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback, SharedPreferences.OnSharedPreferenceChangeListener {
    static long resortId;

    //Pointers to views that will need updating/setting data
    DrawerLayout drawer;
    RecyclerView resortList;
    RecyclerView teamList;
    SupportMapFragment mapView;

    //List of resorts, and lat/long of resortData[0] for use when creating map
    Resort[] resortData;
    double initialLat;
    double initialLong;

    //Shared preferences file for accessing things like selected resort lat/long, and maybe user auth token one day
    private SharedPreferences preferences;

    //Setup for variables needed to fill in RecyclerViews & the map
    private RecyclerView.Adapter resortAdapter;
    private RecyclerView.Adapter teamAdapter;
    private RecyclerView.LayoutManager resortLayoutManager;
    private RecyclerView.LayoutManager teamLayoutManager;
    private GoogleMap map;

    //Create gson instance to parse JSON that comes from backend
    Gson gson = new Gson();

    //Currently here for dev purposes, allows for switching between logged in/logged out view
    boolean isLoggedIn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getSharedPreferences("preferences", 0);

        //TODO: Make this check shared prefs for a token instead
        if (!isLoggedIn) {
            //Show user screen to login
            setContentView(R.layout.activity_login);

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
        } else {
            //Show user main menu screen
            setContentView(R.layout.activity_main);

            //Setup the toolbar
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            resortId = 1;

            //This adds the hamburger for the navigation drawer. Icon can be changed, but rather complicated.
            drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            toggle.getDrawerArrowDrawable().setDirection(DrawerArrowDrawable.ARROW_DIRECTION_RIGHT);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            //Sets up a listener for when a navigation item is selected
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);

            //Add the map fragment into the view. comes from https://developers.google.com/maps/documentation/android-sdk/start
            mapView = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);

            //Gets the recyclerviews from the activity
            resortList = findViewById(R.id.recycler_nav);
            resortList.setHasFixedSize(true);
            teamList = findViewById(R.id.filteredList);
            teamList.setHasFixedSize(true);

            // use a linear layout manager
            resortLayoutManager = new LinearLayoutManager(this);
            teamLayoutManager = new LinearLayoutManager(this);
            resortList.setLayoutManager(resortLayoutManager);
            teamList.setLayoutManager(teamLayoutManager);

            getResorts.execute();

            TextView rightHandHeaderText = findViewById(R.id.rightSideTitle);
            rightHandHeaderText.setText("Resorts");
        }

    }

    //Called after the app has received resort data from the backend, meaning it can successfully draw the starting view
    private void finishCreate() {
        //Edit sharedprefs to ensure map will always change when a new resort it selected, then setup the listener to handle new resort selection
        preferences.edit().putFloat("latitude", (float) resortData[0].getLatitude()).putFloat("longitude", (float) resortData[0].getLongitude()).apply();
        preferences.registerOnSharedPreferenceChangeListener(this);
        initialLat = resortData[0].getLatitude();
        initialLong = resortData[0].getLongitude();

        //Grab textviews and fill them with relevant resort info
        TextView resortName = findViewById(R.id.resortName);
        TextView resortAddress = findViewById(R.id.resortAddress);
        TextView resortWebsite = findViewById(R.id.resortWebsite);

        resortName.setText(resortData[0].getName());
        resortAddress.setText(resortData[0].getAddress());
        resortWebsite.setText(resortData[0].getWebsiteUrl());

        //Let the map know it can start rendering
        mapView.getMapAsync(this);

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

        // Add a marker for the default selected resort, move the camera. Also comes from https://developers.google.com/maps/documentation/android-sdk/start
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

    //Listens for a change to shared preferences, which occurs any time a new resort is selected.
    //Grabs the new lat/long to display, clears the map, adds a new marker, and moves there
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        LatLng coords = new LatLng(preferences.getFloat("latitude", 0), preferences.getFloat("longitude", 0));
        map.clear();
        map.addMarker(new MarkerOptions().position(coords).title("Marker at resort location"));
        map.moveCamera(CameraUpdateFactory.newLatLng(coords));
        map.setMinZoomPreference(8);
    }

    //What do when a navigation item is clicked
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        //Figure out which item was selected, take the user to the desired activity
        if (id == R.id.profile) {
            Intent goToProfile = new Intent(this, UserProfileActivty.class);
            startActivity(goToProfile);
        } else if (id == R.id.groups) {
            Intent goToProfile = new Intent(this, MyGroupsActivity.class);
            startActivity(goToProfile);
        }

        //Close the drawer so it is not still open upon resuming
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //Methods to take users to a different activity for the various buttons available
    public void GoToSignUpActivity(View v) {
        Intent signUpIntent = new Intent(this, Signup.class);
        startActivity(signUpIntent);
    }

    public void goToCreateGroup(View v) {
        Intent goToCreate = new Intent(this, CreateGroupActivity.class);
        goToCreate.putExtra("resortId", resortId);
        startActivity(goToCreate);
    }

    public void performLogin(View v) {
        //TODO: make this do login stuff. Will most likely be get a token from the server, save it in shared prefs, and recreate()
    }

    //Async task called during onCreate to get the list of resorts from the API
    AsyncTask getResorts = new AsyncTask() {

        //Will make a get request for resorts, and then parse that data to be put into the resortData array
        @Override
        protected Object doInBackground(Object[] objects) {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://ec2-54-186-185-206.us-west-2.compute.amazonaws.com/api/v1/resort")
                    .get()
                    .build();
            try {
                Response response = client.newCall(request).execute();
                if (response.code() == 200) {
                    resortData = gson.fromJson(response.body().string(), Resort[].class);
                } else {
                    //If the response code is something other than 200, we probably didn't get our resorts data back
                    return "uh oh";
                }

            } catch (IOException e) {
                //If something fails while trying to get resorts, log the error, and return it
                Log.e("GETRESORTS", e.toString());
                return e;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            //Assuming everything went fine (doInBackground didn't return anything other than null)
            if (o == null) {
                //setup the adapter with the retrieved resortData, and display it
                resortAdapter = new ResortAdapter(resortData);
                resortList.setAdapter(resortAdapter);
                //Get our teams from the API and finish drawing everything else in the mean time
                getTeams.execute();
                finishCreate();
            } else {
                //Something failed when getting our resort info, so display something so the user knows the app couldn't get its data
                TextView resortName = findViewById(R.id.resortName);
                resortName.setText("Error getting Resorts");
            }
        }
    };

    //Called to execute after getting resorts and verifying that actual resort data came back (hopefully)
    AsyncTask getTeams = new AsyncTask() {
        @Override
        protected Object doInBackground(Object[] objects) {

            OkHttpClient client = new OkHttpClient();

            //Setup request to get more specific data about the default displayed resort. Specifically its teams
            Request request = new Request.Builder()
                    .url("http://ec2-54-186-185-206.us-west-2.compute.amazonaws.com/api/v1/resort/" + resortData[0].getId())
                    .get()
                    .build();
            try {
                Response response = client.newCall(request).execute();
                Resort r = gson.fromJson(response.body().string(), Resort.class);
                teamAdapter = new TeamAdapterMain(r.getTeams());
            } catch (IOException e) {
                Log.e("GETEAMS", e.toString());
                //Maybe a way to display to user there was an issue getting team data?
                //Would make it easier to understand if there's no teams there or an error occurred
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            //After getting the team data, set it to display. Android won't allow this to be done within the doInBackground method
            teamList.setAdapter(teamAdapter);
        }
    };

    //--Code below is for features that had to be cut for the sake of time, but could be used later--

    //    Method that creates dropdown for weather
    // Currently not in use due to time restrictions, may be used at a later time
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
    // Currently not in use due to time restrictions, may be used at a later time
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

    //Cut search functionality due to time constraints, can still be added at a later date.
    public void goToSearchActivity(View v) {
        Intent goToSearch = new Intent(this, SearchActivity.class);
        startActivity(goToSearch);
        drawer.closeDrawer(GravityCompat.END);
    }
}
