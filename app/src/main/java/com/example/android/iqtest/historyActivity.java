package com.example.android.iqtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by v4 on 24/01/2018.
 */

public class historyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
    }



    @Override
    public void onBackPressed() {
        Intent mainAct = new Intent(this, MainActivity.class);
        startActivity(mainAct);
        this.finish();
    }
}
