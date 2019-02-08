package com.example.pauls.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "TestApp";
    private Button secondActivityButton;
    private int testIntValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "Created app");

        secondActivityButton = (Button)findViewById(R.id.second_activity_button);
        secondActivityButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the second activity button is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link SecondActivity}
                Intent secondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
                // Start the new activity
                startActivity(secondActivityIntent);
            }
        });

        testIntValue=13;
        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("your_int_key", testIntValue);
        editor.commit();
    }

    @Override
    public void onClick(View v) {

        if (v == secondActivityButton) {
            Log.i(TAG, "Button Clicked");


        }
    }
}
