package com.twelvesixty.peak;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onProfileButtonClick(View view) {
        Intent navigateToProfile = new Intent(getApplicationContext(), UserProfileActivty.class);
        startActivity(navigateToProfile);
        setContentView(R.layout.activity_user_profile_activty);
    }
}
