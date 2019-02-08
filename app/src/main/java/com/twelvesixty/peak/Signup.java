package com.twelvesixty.peak;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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

        //get fields & their input
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

        //(stretch)check if fields are valid
        //make an object
        String fullName = firstNameInput + " " + lastNameInput;
        User newestUser = new User(fullName, usernameInput, dobInput, emailInput, bioInput);
        registarUser();
        //jsonify


        //send

    }


    public void registarUser(){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://ec2-54-186-185-206.us-west-2.compute.amazonaws.com/api/v1/register?username=Pablo&password=1&firstName=Pablo&lastName=Rosales&birthDate=09/03/1995&email=p@gmail.com&bio=Im%20alive")
                .post(null)
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "c04a5349-807b-4bca-8977-95913d82ea84")
                .build();
try {
    Response response = client.newCall(request).execute();
}   catch(Exception e){

}
    }



}
