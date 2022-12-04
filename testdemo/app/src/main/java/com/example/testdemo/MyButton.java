package com.example.testdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatButton;

public class MyButton extends  AppCompatButton{

    public MyButton(Context context, AttributeSet attrs)
    {
        super(context,attrs);
    }

    //重写键盘按下触发的事件

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        super.onKeyDown(keyCode, event);
        Log.i("哈哈", "自定义按钮的onKeyDown方法被调用");
        return false;
    }
}

