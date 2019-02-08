package com.twelvesixty.peak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    EditText usernameInputField = findViewById(R.id.UserSignUp);
    String usernameInput = usernameInputField.getText().toString();

    EditText emailInputField = findViewById(R.id.EmailSignUp);
    String emailInput = emailInputField.getText().toString();

    EditText bioInputField = findViewById(R.id.BioSignUp);
    String bioInput = bioInputField.getText().toString();

    EditText passwordInputField = findViewById(R.id.PasswordSignUp);
    String passwordInput = passwordInputField.getText().toString();

    EditText dobInputField = findViewById(R.id.DOBSignUp);
    String dobInput = dobInputField.getText().toString();

}
