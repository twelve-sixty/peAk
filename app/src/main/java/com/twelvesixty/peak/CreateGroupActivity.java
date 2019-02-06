package com.twelvesixty.peak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class CreateGroupActivity extends AppCompatActivity {
    // group category checkboxes
    CheckBox bluesAndBrews;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
    }

    // on click method that takes in all of that data
    // need to account for when users don't fill in certain fields

    public void onCreateGroupButtonClick(View view){
        // find all edit text views by ID
        // create Group object with data
        // send that data off to the backend in a post body
    }
}
