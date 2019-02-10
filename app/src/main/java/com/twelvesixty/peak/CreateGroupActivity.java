package com.twelvesixty.peak;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class CreateGroupActivity extends AppCompatActivity {
    // id variables for category names
    final int partyHardyID = R.id.checkBox_PartyHardy;
    final int offPisteID = R.id.checkBox_OffPiste;
    final int terrainParkID = R.id.checkBox_TerrainPark;
    final int familyFriendlyID = R.id.checkBox_FamilyFriendly;

    // id variables for difficulties
    final int greenCircleID = R.id.checkBox_GreenCircle;
    final int blueSquareID = R.id.checkBox_BlueSquare;
    final int blackDiamondID = R.id.checkBox_BlackDiamonds;
    final int doubleblackDiamondID = R.id.checkBox_DoubleBlackDiamonds;

    // difficulty tags stored as class variables for use across methods
    boolean greenCircleTag = false;
    boolean blueSquareTag = false;
    boolean blackDiamondTag = false;
    boolean doubleBlackDiamondTag = false;

    // group category tags stored as class variables for use across methods
    boolean partyHardyTag = false;
    boolean offPisteTag = false;
    boolean terrainParkTag = false;
    boolean familyFriendlyTag = false;

    //int to know which resortId the group will be added to
    long resortId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        Intent data = getIntent();
        resortId = data.getLongExtra("resortId",  1);
        Log.i("RESORTID", Long.toString(resortId));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
    }

    // onClick method that creates a new team object from form data and saves object to database
    public void onCreateTeamButtonClick(View view){

        // create Team string fields from EditText form data
        EditText capacityEditText = findViewById(R.id.editText_capacity);
        EditText groupNameEditText = findViewById(R.id.editText_groupName);
        EditText dateGoingEditText = findViewById(R.id.editText_groupDateGoing);
        EditText timeGoingEditText = findViewById(R.id.editText_groupTimeMeeting);
        EditText descriptionEditText = findViewById(R.id.editText_groupDescription);

        int capacityFormInput = Integer.parseInt(capacityEditText.getText().toString());
        String groupNameFormInput = groupNameEditText.getText().toString();
        String dateGoingFormInput = dateGoingEditText.getText().toString();
        String timeGoingFormInput = timeGoingEditText.getText().toString();
        String descriptionFormInput = descriptionEditText.getText().toString();

        // for testing purposes only (will pull these data from logged in user)
        User fakeTeamLeader = new User();
        fakeTeamLeader.setName("Fake User");
        fakeTeamLeader.setId(1);
        fakeTeamLeader.setUsername("faker999");
        fakeTeamLeader.setDateOfBirth("1/1/2001");
        fakeTeamLeader.setEmail("myEmail@gmail.com");
        fakeTeamLeader.setBio("let's get it");

        ArrayList<Team> teamList = new ArrayList<>();

        Resort fakeResort = new Resort("ASUS", 47.062, 47.062, "https://www.google.com/", teamList);


        // create list of tags based on checkbox onClick listener input
        HashMap<String,Boolean> tagsMap = generateTagsList();

        // construct new Team object with user input data
        final Team newTeam = new Team(capacityFormInput, groupNameFormInput, dateGoingFormInput,
                descriptionFormInput, tagsMap, fakeTeamLeader, fakeResort, "Active");

        // need HTTP request sent back to backend
        // need to then populate the new form with these data
        // need to add this user to the list of users in that team
        final String url = "http://ec2-54-186-185-206.us-west-2.compute.amazonaws.com/api/v1/team";

        AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                createTeam(url, newTeam, resortId);
                return null;
            }
        };

        asyncTask.execute();

        finish();


    }


    // checkbox click method inspired by: https://developer.android.com/guide/topics/ui/controls/checkbox
    // onClick listener for group category tags. If tags clicked, boolean variable set to true
    public void onCategoryCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case partyHardyID:
                if (checked)
                    partyHardyTag = true;
                else
                    partyHardyTag = false;
                break;
            case offPisteID:
                if (checked)
                    offPisteTag = true;
                else
                    offPisteTag = false;
                break;
            case terrainParkID:
                if (checked)
                    terrainParkTag = true;
                else
                    terrainParkTag = false;
                break;
            case familyFriendlyID:
                if (checked)
                    familyFriendlyTag = true;
                else
                    familyFriendlyTag = false;
                break;
        }
    }

    // checkbox click method inspired by: https://developer.android.com/guide/topics/ui/controls/checkbox
    // onClick listener for difficulty checkboxes, changes boolean value of the tag
    public void onDifficultyCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case greenCircleID:
                if (checked)
                    greenCircleTag = true;
                else
                    greenCircleTag = false;
                break;
            case blueSquareID:
                if (checked)
                    blueSquareTag = true;
                else
                    blueSquareTag = false;
                break;
            case blackDiamondID:
                if (checked)
                    blackDiamondTag = true;
                else
                    blackDiamondTag = false;
                break;
            case doubleblackDiamondID:
                if (checked)
                    doubleBlackDiamondTag = true;
                else
                    doubleBlackDiamondTag = false;
                break;
        }
    }


    // helper method which generates our list of tags and their statuses (key = tag name; value = boolean)
    private HashMap<String, Boolean> generateTagsList() {
        HashMap<String, Boolean> tagsMapList = new HashMap<>();

        tagsMapList.put("greenCircle", greenCircleTag);
        tagsMapList.put("blueSquare", blueSquareTag);
        tagsMapList.put("blackDiamond", blackDiamondTag);
        tagsMapList.put("doubleBlackDiamond", doubleBlackDiamondTag);

        tagsMapList.put("partyHardy", partyHardyTag);
        tagsMapList.put("offPiste", offPisteTag);
        tagsMapList.put("terrainPark", terrainParkTag);
        tagsMapList.put("familyFriendly", familyFriendlyTag);

        return tagsMapList;



    }


    // inspired by: https://stackoverflow.com/questions/40523965/sending-json-body-through-post-request-in-okhttp-in-android/40524159
    public static void createTeam(String url, Team team, long resortId) {

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        String postContent = "team_name=" + team.getName() + "&team_description=" + team.getDescription()+ "&team_max_capacity=" + team.getMaxCapacity() + "&team_administrator=" + 1 + "&team_resort=" + resortId + "&team_meet_date=" + team.getDateAndTimeGoingGoing();
        RequestBody body = RequestBody.create(mediaType, postContent);
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .post(body)
                .build();
        try {
            okhttp3.Response response = client.newCall(request).execute();
            Log.i("this is our response", response.toString());
        } catch (Exception e) {
            Log.i("PostError", e.toString());
        }


    }
}
