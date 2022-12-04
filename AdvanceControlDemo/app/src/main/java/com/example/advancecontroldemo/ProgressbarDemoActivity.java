package com.example.advancecontroldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

public class ProgressbarDemoActivity extends AppCompatActivity {
    ProgressBar pg_one;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar_demo);
        pg_one = findViewById(R.id.pg_one);
        pg_one.setProgress(50);
        pg_one.incrementProgressBy(15);
    }
}
