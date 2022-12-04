package com.example.handlerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class HandlerActivity extends AppCompatActivity {
    int imgids[] = new int[]{
            R.mipmap.s1, R.mipmap.s2,R.mipmap.s3,R.mipmap.s4,R.mipmap.s5,
            R.mipmap.s6, R.mipmap.s7,R.mipmap.s8,R.mipmap.s9,R.mipmap.s10,
            R.mipmap.s11, R.mipmap.s12,R.mipmap.s13,R.mipmap.s14,R.mipmap.s15,
            R.mipmap.s16, R.mipmap.s17,R.mipmap.s18,R.mipmap.s19,R.mipmap.s20,
            R.mipmap.s21, R.mipmap.s22,R.mipmap.s23,R.mipmap.s24,R.mipmap.s25,
            R.mipmap.s26, R.mipmap.s27,R.mipmap.s28,R.mipmap.s29,R.mipmap.s30,
            R.mipmap.s31, R.mipmap.s32,R.mipmap.s33,R.mipmap.s34,R.mipmap.s35,
            R.mipmap.s36, R.mipmap.s37,R.mipmap.s38,R.mipmap.s39,R.mipmap.s40,
            R.mipmap.s41, R.mipmap.s42,R.mipmap.s43,R.mipmap.s44,R.mipmap.s45
    };
    int imgstart = 0;
    ImageView imgchange;
    final Handler myHandler = new Handler()
    {
        @Override
        //重写handleMessage方法,根据msg中what的值判断是否执行后续操作
        public void handleMessage(Message msg) {
            if(msg.what == 0x123)
            {
                imgchange.setImageResource(imgids[imgstart++ % 45]);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgchange= (ImageView) findViewById(R.id.imgchange);

        //使用定时器,每隔200毫秒让handler发送一个空信息
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                myHandler.sendEmptyMessage(0x123);

    }
}, 0,200);
    }
}
