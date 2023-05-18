package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText; // <--- this is the import that is required for EditText to work in your code
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
public class SecondActivity extends AppCompatActivity {

    private SharedPreferences myPreferenceRef;
    private SharedPreferences.Editor myPreferenceEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button button = findViewById(R.id.start_first_activity);

        @SuppressLint({"MissingInflatedId","LocalSuppress"}) TextView textview=findViewById(R.id.prefText);

// Get a reference to the shared preference
        myPreferenceRef= getSharedPreferences("MyPreferenceName",MODE_PRIVATE);
        myPreferenceEditor= myPreferenceRef.edit();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
        public void savePref(View v){
            // Get the text
            EditText newPrefText=new EditText(this);
            newPrefText=(EditText)findViewById(R.id.settingseditview);

            // Store the new preference
            myPreferenceEditor.putString("MyAppPreferenceString", newPrefText.getText().toString());
            myPreferenceEditor.apply();

            // Display the new preference
            TextView prefTextRef=new TextView(this);
            prefTextRef=(TextView)findViewById(R.id.prefText);
            prefTextRef.setText(myPreferenceRef.getString("MyAppPreferenceString", "No preference found."));

            // Clear the EditText
            newPrefText.setText("");
        }

}