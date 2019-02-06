package com.twelvesixty.peak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class GroupDetailsActivity extends AppCompatActivity {
    Button editGroupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_details);

        // find views by id
        editGroupButton = findViewById(R.id.editGroupButton);

        //if this user is the group admin, show the edit button

    }
}
