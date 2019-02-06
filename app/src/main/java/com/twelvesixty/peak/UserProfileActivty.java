package com.twelvesixty.peak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class UserProfileActivty extends AppCompatActivity {
    LinearLayout defaultProfileLayout;
    LinearLayout editableLayout;
    Button editProfileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_activty);

        // find views by id
        editableLayout = findViewById(R.id.linearLayout_editable);
        defaultProfileLayout = findViewById(R.id.linearLayout_default);
        editProfileButton = findViewById(R.id.button_EditProfile);

        // set editable layout view to GONE
        editableLayout.setVisibility(View.GONE);

    }

    // show users content from profile or provide editable content
    public void onEditProfileButtonClick(View view) {

        String buttonText = editProfileButton.getText().toString().toLowerCase();

        if(buttonText.equals("edit profile")) {
            flipToEditMode();
            buttonText = "Save";
            editProfileButton.setText(buttonText);

        } else {
            flipToDefaultMode();
            buttonText = "Edit Profile";
            editProfileButton.setText(buttonText);

            EditText bioFormEditView = findViewById(R.id.textView_Bio_Editable);
            String bioFormInput = bioFormEditView.getText().toString();

            EditText favoriteResortEditView = findViewById(R.id.textView_favoriteResort_Editable);
            String favoriteResortFormInput = favoriteResortEditView.getText().toString();

            TextView bioTextView = findViewById(R.id.textView_Bio);
            TextView favoriteResortTextView = findViewById(R.id.textView_favoriteResort);

            if(!bioFormInput.equals("")) {
                Log.i("bioFormInput", bioFormInput);
                bioTextView.setText(bioFormInput);
            }

            if(!favoriteResortFormInput.equals("")) {
                Log.i("favoriteResortInput", favoriteResortFormInput);
                favoriteResortTextView.setText(favoriteResortFormInput);
            }
            ;
        }
    }

    // flip layouts from default content to editable content
    private void flipToEditMode() {
        defaultProfileLayout.setVisibility(View.GONE);
        editableLayout.setVisibility(View.VISIBLE);
    }

    // flip layout from editable content to default content
    private void flipToDefaultMode() {
        editableLayout.setVisibility(View.GONE);
        defaultProfileLayout.setVisibility(View.VISIBLE);
    }
}
