package com.twelvesixty.peak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class Signup extends AppCompatActivity {
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signUpButton = findViewById(R.id.holyGrail);
    }

    public void onSignUpButtonClick(View view) {
        //(stretch)check if fields are valid

        //make an object

        String fullName = firstNameInput + " " + lastNameInput;
        User newestUser = new User(fullName, usernameInput, dobInput, emailInput, bioInput);

        //jsonify


        //send

    }

    EditText firstNameInputField = findViewById(R.id.UserFirstname);
    String firstNameInput = firstNameInputField.getText().toString();

    EditText lastNameInputField = findViewById(R.id.UserLastname);
    String lastNameInput = lastNameInputField.getText().toString();

    EditText usernameInputField = findViewById(R.id.UserSignUp);
    String usernameInput = usernameInputField.getText().toString();

    EditText passwordInputField = findViewById(R.id.PasswordSignUp);
    String passwordInput = passwordInputField.getText().toString();

    EditText bioInputField = findViewById(R.id.BioSignUp);
    String bioInput = bioInputField.getText().toString();

    EditText dobInputField = findViewById(R.id.DOBSignUp);
    String dobInput = dobInputField.getText().toString();

    EditText emailInputField = findViewById(R.id.EmailSignUp);
    String emailInput = emailInputField.getText().toString();


}
