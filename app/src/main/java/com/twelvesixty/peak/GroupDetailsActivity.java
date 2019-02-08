package com.twelvesixty.peak;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GroupDetailsActivity extends AppCompatActivity {
    private Gson gson = new Gson();
    Button editGroupButton;
    LinearLayout defaultGroupLayout;
    LinearLayout editableGroupLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);

        Team team = gson.fromJson("{\n" +
                "    \"id\": 3,\n" +
                "    \"name\": \"Team 2-2\",\n" +
                "    \"description\": \"Descriptions are lame\",\n" +
                "    \"capacity\": 3,\n" +
                "    \"dateAndTimeGoing\": \"11/21/19 11:00AM\",\n" +
                "    \"teamLeader\": null,\n" +
                "    \"resort\": null,\n" +
                "    \"userList\": [\n" +
                "        {\n" +
                "            \"id\": 1,\n" +
                "            \"username\": \"NJCrain\",\n" +
                "            \"name\": \"Nick\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 2,\n" +
                "            \"username\": \"DarrinHowell\",\n" +
                "            \"name\": \"Darrin\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 3,\n" +
                "            \"username\": \"jasonb315\",\n" +
                "            \"name\": \"Jason\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"messagesList\": null\n" +
                "}", Team.class);

        TextView groupName = findViewById(R.id.groupName);
        groupName.setText(team.getName());
        // find views by id
        editGroupButton = findViewById(R.id.editGroupButton);
        defaultGroupLayout = findViewById(R.id.LinearLayout_GroupDetails);
        editableGroupLayout = findViewById(R.id.LinearLayout_GroupDetails);

        // if this user is the group admin, show the edit button
//        if(User.getOwnsGroup()){
//          editGroupButton.setVisibility(View.VISIBLE);
//        }

    }

    // Method shows users details about a group and can provide editable content for the owner to update
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


}
