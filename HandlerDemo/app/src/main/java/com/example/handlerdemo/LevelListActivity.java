package com.example.handlerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class LevelListActivity extends AppCompatActivity {

    private ImageView show;
    LevelListDrawable ld;
    Handler myhandler=new Handler()
    {
        public void handleMessage(Message msg)
        {
            if(msg.what==0x12)
            {
                if(ld.getLevel()>5000)
                    ld.setLevel(0);
                show.setImageLevel(ld.getLevel()+1000);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_list);
        show=findViewById(R.id.image2);
        ld=(LevelListDrawable) show.getDrawable();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                myhandler.sendEmptyMessage(0x12);
            }
        },0,300);
    }
}
