package com.example.handlerdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

public class IPreciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent)
    {
        System.out.println("有电话了");

    Log.i("哈哈", "有外拨电话了...");
    //取出区号
    SharedPreferences sp = context.getSharedPreferences("config",context.MODE_PRIVATE);
    String number = sp.getString("number","");
    //Toast.makeText(this,number,Toast.LENGTH_SHORT).show();
    //取出外拨电话号码
    String currentNumber = getResultData();
    //区号+电话号码生成新的电话号码
    String newNumber = number+currentNumber;
    //新的电话号码再拨出去
    setResultData(newNumber);
   }
}
