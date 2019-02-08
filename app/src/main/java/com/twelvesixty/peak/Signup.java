package com.twelvesixty.peak;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONObject;


public class Signup extends AppCompatActivity {
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signUpButton = findViewById(R.id.holyGrail);
    }

    //target the fields
    EditText firstNameInputField = findViewById(R.id.UserFirstname);
    String firstNameInput = firstNameInputField.getText().toString();

    EditText lastNameInputField = findViewById(R.id.UserLastname);
    String lastNameInput = lastNameInputField.getText().toString();

    EditText usernameInputField = findViewById(R.id.UserSignUp);
    EditText passwordInputField = findViewById(R.id.PasswordSignUp);
    EditText bioInputField = findViewById(R.id.BioSignUp);
    EditText dobInputField = findViewById(R.id.DOBSignUp);
    EditText emailInputField = findViewById(R.id.EmailSignUp);

    public void onSignUpButtonClick(View view) {
        //grab the users input
        String usernameInput = usernameInputField.getText().toString();
        String passwordInput = passwordInputField.getText().toString();
        String bioInput = bioInputField.getText().toString();
        String dobInput = dobInputField.getText().toString();
        String emailInput = emailInputField.getText().toString();

        //(stretch)check if fields are valid


        //make a user object from input
        String fullName = firstNameInput + " " + lastNameInput;
        User newestUser = new User(fullName, usernameInput, dobInput, emailInput, bioInput);

        //send this user object in a post request to /register
        registerUser(newestUser, firstNameInput, lastNameInput);


    }

    //Method from Postman to make a request for their backend routes with the proper requirements
    public void registerUser(User user,String firstNameInput, String lastNameInput){
        OkHttpClient client = new OkHttpClient();

        //needs a password to be encrypted & sent as well
        Request request = new Request.Builder()
                .url("http://ec2-54-186-185-206.us-west-2.compute.amazonaws.com/api/v1/register?username=user.username&password=PASSWORD&firstName=firstNameInput&lastName=lastNameInput&birthDate=user.dateOfBirth&email=user.email&bio=user.bio")
                .post(null)
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "c04a5349-807b-4bca-8977-95913d82ea84")
                .build();
        try {
            Response response = client.newCall(request).execute();
        } catch(Exception e){
            //
        }
    }



}
