package com.twelvesixty.peak.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.gson.Gson;
import com.twelvesixty.peak.R;
import com.twelvesixty.peak.adapter.MyGroupAdapter;
import com.twelvesixty.peak.model.Team;

public class MyGroupsActivity extends AppCompatActivity {
    RecyclerView groupList;
    Gson gson = new Gson();
    private RecyclerView.Adapter groupAdapter;
    private RecyclerView.LayoutManager groupLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_groups);

        //Setup the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Enable the back arrow on the toolbar
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);

        //Currently builds the list from dummy JSON, as there is not yet a route to get this info
        Team[] groups = gson.fromJson("[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Team 1-1\",\n" +
                "        \"description\": \"Here is a short amount of words\",\n" +
                "        \"capacity\": 3,\n" +
                "        \"meetDate\": \"1/4/19 9:00AM\",\n" +
                "        \"resort\": null,\n" +
                "        \"status\": \"active\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 3,\n" +
                "        \"name\": \"Team 2-2\",\n" +
                "        \"description\": \"Descriptions are lame\",\n" +
                "        \"capacity\": 3,\n" +
                "        \"meetDate\": \"11/21/19 11:00AM\",\n" +
                "        \"resort\": null,\n" +
                "        \"status\": \"active\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 4,\n" +
                "        \"name\": \"Team 3-1\",\n" +
                "        \"description\": \"yes\",\n" +
                "        \"capacity\": 3,\n" +
                "        \"meetDate\": \"11/8/19 8:00AM\",\n" +
                "        \"resort\": null,\n" +
                "        \"status\": \"active\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 5,\n" +
                "        \"name\": \"Team 3-2\",\n" +
                "        \"description\": \"\",\n" +
                "        \"currentCapacity\": 3,\n" +
                "        \"capacity\": 3,\n" +
                "        \"meetDate\": \"12/31/19 12:00AM\",\n" +
                "        \"resort\": null,\n" +
                "        \"status\": \"active\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 6,\n" +
                "        \"name\": \"Team 3-3\",\n" +
                "        \"description\": \"bbh\",\n" +
                "        \"capacity\": 3,\n" +
                "        \"meetDate\": \"1/15/19 9:00AM\",\n" +
                "        \"resort\": null,\n" +
                "        \"status\": \"active\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 7,\n" +
                "        \"name\": \"A Name\",\n" +
                "        \"description\": \"test\",\n" +
                "        \"capacity\": 5,\n" +
                "        \"meetDate\": \"2/10/19 8:00AM\",\n" +
                "        \"resort\": null,\n" +
                "        \"status\": \"active\"\n" +
                "    }\n" +
                "]", Team[].class);

        //Grab the RecyclerView and set its content
        groupList = findViewById(R.id.groupsList);
        groupList.setHasFixedSize(true);

        groupLayoutManager = new LinearLayoutManager(this);
        groupList.setLayoutManager(groupLayoutManager);

        groupAdapter = new MyGroupAdapter(groups);
        groupList.setAdapter(groupAdapter);
    }
}
