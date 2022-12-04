package com.example.handlerdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ReceiverActivity extends AppCompatActivity {

    EditText et;

    // 允许程序监视、修改有关拨出电话PROCESS_OUTGOING_CALLS
    private static final int PROCESS_OUTGOING_CALLS = 1;
    private static String[] OUTGOING_CALLS = {Manifest.permission.PROCESS_OUTGOING_CALLS};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        et=findViewById(R.id.edit1);
    }

    public static void verifyPermissions(Activity activity) {
        // Check if we have PROCESS_OUTGOING_CALLS permission检查应用是否拥有监听修改播出电话的权限
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.PROCESS_OUTGOING_CALLS);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user如果我们没有权限就弹出提示请求用户赋予权限
            ActivityCompat.requestPermissions(activity, OUTGOING_CALLS, PROCESS_OUTGOING_CALLS);
        }
    }

    //按钮的监听方法
    public void save(View v){
        verifyPermissions(this);
        String number = et.getText().toString().trim();
        //Toast.makeText(ReceiverActivity.this,number,Toast.LENGTH_LONG).show();
        if (TextUtils.isEmpty(number)) {
            Toast.makeText(this, "区号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPreferences sp = getSharedPreferences("config",MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("number",number);
        edit.commit();
    }


}
