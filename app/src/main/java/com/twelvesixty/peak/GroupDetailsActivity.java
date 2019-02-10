package com.twelvesixty.peak;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GroupDetailsActivity extends AppCompatActivity {
    Button editGroupButton;
    LinearLayout defaultGroupLayout;
    LinearLayout editableGroupLayout;
    DrawerLayout drawers;
    RecyclerView userList;
    private RecyclerView.Adapter userAdapter;
    private RecyclerView.LayoutManager userLayoutManager;
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_details);

        //grab drawerLayout to handle various events for opening/closing it
        drawers = findViewById(R.id.right_drawer_only);

        //Set drawer header text to match what will be displayed there
        TextView rightHandHeaderText = findViewById(R.id.rightSideTitle);
        rightHandHeaderText.setText("Users");

        //Setup the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Enable the back arrow on the toolbar
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);

        //Get the id for the team selected to view details of, make the call to get the data for that ID
        Intent intent = getIntent();
        long teamId = intent.getLongExtra("teamId", 1);
        getTeamInfo.execute(teamId);



        //Setup userList Recycler and display data (currently none as backend doesn't send users)
        userList = findViewById(R.id.recycler_nav);
        userList.setHasFixedSize(true);

        userLayoutManager = new LinearLayoutManager(this);
        userList.setLayoutManager(userLayoutManager);

        // find views by id
        editGroupButton = findViewById(R.id.editGroupButton);
        defaultGroupLayout = findViewById(R.id.LinearLayout_GroupDetails);
        editableGroupLayout = findViewById(R.id.LinearLayout_GroupEditable);

        // if this user is the group admin, show the edit button. Currently not usable at this time
//        if(User.getOwnsGroup()){
//          editGroupButton.setVisibility(View.VISIBLE);
//        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.group, menu);
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
            drawers.openDrawer(GravityCompat.END);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //Close the userList if it is open
        if (drawers.isDrawerOpen(GravityCompat.END)) {
            drawers.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }

    // Method shows users details about a group and can provide editable content for the owner to update
    //Currently not in use at the moment, but can be setup for use later easily
    public void onEditGroupButtonClick(View view) {

        String buttonText = editGroupButton.getText().toString().toLowerCase();

        if(buttonText.equals("edit group")) {

            flipToEditMode();
            buttonText = "Save";
            editGroupButton.setText(buttonText);

        } else {

            buttonText = "Edit group";
            editGroupButton.setText(buttonText);

            //grabbing user inputs for each field
            EditText groupNameFormEditView = findViewById(R.id.nameInputField);
            String groupNameInput = groupNameFormEditView.getText().toString();

            EditText meetingDateFormEditView = findViewById(R.id.dateInputField);
            String meetingDateInput = meetingDateFormEditView.getText().toString();

            EditText meetingTimeFormEditView = findViewById(R.id.timeInputField);
            String meetingTimeInput = meetingTimeFormEditView.getText().toString();

            EditText ResortFormEditView = findViewById(R.id.resortInputField);
            String resortInput = ResortFormEditView.getText().toString();

            EditText maximumCapacityFormEditView = findViewById(R.id.capacityInputField);
            String maximumCapacityInput = maximumCapacityFormEditView.getText().toString();

            EditText descriptionFormEditView = findViewById(R.id.descriptionInputField);
            String descriptionInput = descriptionFormEditView.getText().toString();

            EditText statusFormEditView = findViewById(R.id.statusInputField);
            String statusInput = statusFormEditView.getText().toString();

            //grabbing the default text views for updates
            TextView groupNameTextView = findViewById(R.id.groupName);
            TextView meetingDateAndTimeTextView = findViewById(R.id.dateLabel);
            TextView resortTextView = findViewById(R.id.resortLabel);
            TextView groupMaxCapacityTextView = findViewById(R.id.capacityLabel);
            TextView groupDescriptionTextView = findViewById(R.id.descriptionLabel);
            TextView groupStatusTextView = findViewById(R.id.stateLabel);

            String timeAndDateToMeet = meetingDateInput + " at " + meetingTimeInput;

            // if users provide content, reset the text in the appropriate fields
            if(!groupNameInput.equals("")) {
                Log.i("groupNameInput", groupNameInput);
                groupNameTextView.setText(groupNameInput);
            }

            if(!meetingDateInput.equals("") || !meetingTimeInput.equals("")) {
                Log.i("meetingDateInput", meetingDateInput);
                Log.i("meetingTimeInput", meetingTimeInput);
                meetingDateAndTimeTextView.setText(timeAndDateToMeet);
            }

            if(!resortInput.equals("")) {
                Log.i("resortInput", resortInput);
                resortTextView.setText(resortInput);
            }

            if(!maximumCapacityInput.equals("")) {
                Log.i("maximumCapacityInput", maximumCapacityInput);
                groupMaxCapacityTextView.setText(maximumCapacityInput);
            }

            if(!descriptionInput.equals("")) {
                Log.i("descriptionInput", descriptionInput);
                groupDescriptionTextView.setText(descriptionInput);
            }

            if(!statusInput.equals("")) {
                Log.i("statusInput", statusInput);
                groupStatusTextView.setText(statusInput);
            }

            flipToDefaultMode();

        }
    }

    // flip layouts from default content to editable content
    private void flipToEditMode() {
        defaultGroupLayout.setVisibility(View.GONE);
        editableGroupLayout.setVisibility(View.VISIBLE);
    }

    // flip layout from editable content to default content
    private void flipToDefaultMode() {
        editableGroupLayout.setVisibility(View.GONE);
        defaultGroupLayout.setVisibility(View.VISIBLE);
    }

    private void finishCreate(Team team) {
        //Grabs all the text views and sets their text with relevant team info
        TextView groupNameTextView = findViewById(R.id.groupName);
        TextView meetingDateAndTimeTextView = findViewById(R.id.dateLabel);
        TextView resortTextView = findViewById(R.id.resortLabel);
        TextView groupMaxCapacityTextView = findViewById(R.id.capacityLabel);
        TextView groupDescriptionTextView = findViewById(R.id.descriptionLabel);
        TextView groupStatusTextView = findViewById(R.id.stateLabel);

        groupNameTextView.setText(team.getName());
        meetingDateAndTimeTextView.setText("Meeting on: " + team.getDateAndTimeGoingGoing());
        resortTextView.setText("Going to: " + "Resort Name");
        groupMaxCapacityTextView.setText("Capacity: " + team.getCurrentCapacity() + "/" + team.getMaxCapacity());
        groupDescriptionTextView.setText("Description: " + team.getDescription());
        groupStatusTextView.setText("Status: " + team.getStatus());
    }

    //Asynctask to grab the detailed information for the team
    AsyncTask getTeamInfo = new AsyncTask() {
        @Override
        protected Object doInBackground(Object[] objects) {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://ec2-54-186-185-206.us-west-2.compute.amazonaws.com/api/v1/team/" + objects[0])
                    .get()
                    .build();

            try {
                Response response = client.newCall(request).execute();
                Team t = gson.fromJson(response.body().string(), Team.class);
                return t;
            } catch (IOException e) {
                Log.e("GETTEAMINFO", e.toString());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            //Takes in the team retrieved from the API to display the info
            //If the team is null, let the user know something went wrong
            Team t = (Team)o;
            if (t == null) {
                TextView groupNameTextView = findViewById(R.id.groupName);
                groupNameTextView.setText("Could not get team info");

            }else {
                if (t.getUserList() != null) {
                    //Only create an adapter for users if they exist (only an issue with current API state)
                    userAdapter = new UserAdapter(t.getUserList());
                    userList.setAdapter(userAdapter);
                }
                finishCreate(t);
            }
        }
    };
}
