package com.example.android.iqtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String THE_NAME = "the name";
    public static final String THT_AGE = "the age";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Method starts the test
//to start test must enter name and age
    public void openTest(View view) {
        Intent openTestActivity = new Intent(this, TestActivity.class);
        EditText name = findViewById(R.id.name);
        String theName = name.getText().toString();
        EditText age = findViewById(R.id.age);
        String theAge = age.getText().toString();
        if (theName.equals("") || theAge.equals("")) {
            Toast.makeText(this, R.string.no_name_age_erroe, Toast.LENGTH_SHORT).show();
        } else {
            openTestActivity.putExtra(THE_NAME, theName);
            openTestActivity.putExtra(THT_AGE, theAge);
            startActivity(openTestActivity);
            this.finish();
        }
    }

    public void openHistory(View view) {
        Intent openHistoryActivity = new Intent(this, historyActivity.class);
        startActivity(openHistoryActivity);
        this.finish();
    }
}