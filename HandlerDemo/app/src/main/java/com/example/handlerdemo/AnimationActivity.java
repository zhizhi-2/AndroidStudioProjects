package com.example.handlerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {

    private ImageView im;
    private AnimationDrawable ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        im=findViewById(R.id.image1);
        ad=(AnimationDrawable)im.getDrawable();
        Handler handler=new Handler();
        handler.postDelayed(new Runnable()
        {
            public void  run()
            {
                ad.start();
            }
        },0,3000);

    }
}
