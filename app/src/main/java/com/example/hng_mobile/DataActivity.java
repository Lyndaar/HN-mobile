package com.example.hng_mobile;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DataActivity extends AppCompatActivity {
    TextView mDisplay;
    String data;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_display);

        sharedPreferences = getSharedPreferences("MYPREFRENCE", MODE_PRIVATE);
        data=sharedPreferences.getString("data", "");


         mDisplay = findViewById(R.id.textViewName);
         mDisplay.setText(data);
    }
}
