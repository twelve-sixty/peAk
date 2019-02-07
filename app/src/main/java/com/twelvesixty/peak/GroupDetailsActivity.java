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

public class GroupDetailsActivity extends AppCompatActivity {
    Button editGroupButton;
    LinearLayout defaultGroupLayout;
    LinearLayout editableGroupLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_details);

        // find views by id
        editGroupButton = findViewById(R.id.editGroupButton);
        defaultGroupLayout = findViewById(R.id.LinearLayout_GroupDetails);
        editableGroupLayout = findViewById(R.id.LinearLayout_GroupDetails);

        // if this user is the group admin, show the edit button
//        if(The user owns this group){
//          editGroupButton.setVisibility(View.VISIBLE);
//        }

    }

    // show users content from profile or provide editable content
    public void onEditProfileButtonClick(View view) {

        String buttonText = editGroupButton.getText().toString().toLowerCase();

        if(buttonText.equals("edit group")) {

            flipToEditMode();
            buttonText = "Save";
            editGroupButton.setText(buttonText);

        } else {

            buttonText = "Edit group";
            editGroupButton.setText(buttonText);

            EditText bioFormEditView = findViewById(R.id.textView_Bio_Editable);
            String bioFormInput = bioFormEditView.getText().toString();

            EditText favoriteResortEditView = findViewById(R.id.textView_favoriteResort_Editable);
            String favoriteResortFormInput = favoriteResortEditView.getText().toString();

            TextView bioTextView = findViewById(R.id.textView_Bio);
            TextView favoriteResortTextView = findViewById(R.id.textView_favoriteResort);

            // if users provide content, reset the text in the user profile
            if(!bioFormInput.equals("")) {
                Log.i("bioFormInput", bioFormInput);
                bioTextView.setText(bioFormInput);
            }

            // if users provide content for favresort, then update textview
            if(!favoriteResortFormInput.equals("")) {
                Log.i("favoriteResortInput", favoriteResortFormInput);
                favoriteResortTextView.setText(favoriteResortFormInput);
            }

            flipToDefaultMode();

        }
    }

    // flip layouts from default content to editable content
    private void flipToEditMode() {
        defaultGroupLayout.setVisibility(View.GONE);
        editableGroupLayout.setVisibility(View.VISIBLE);
    }

    // flip layout from editable content to default content
    private void flipToDefaultMode() {
        editableGroupLayout.setVisibility(View.GONE);
        defaultGroupLayout.setVisibility(View.VISIBLE);
    }
}
