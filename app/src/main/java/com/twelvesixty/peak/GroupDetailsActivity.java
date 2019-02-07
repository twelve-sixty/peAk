package com.twelvesixty.peak;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class GroupDetailsActivity extends AppCompatActivity {
    private Gson gson = new Gson();

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
    }


}
