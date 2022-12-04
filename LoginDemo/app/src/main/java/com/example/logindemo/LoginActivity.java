package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.reflect.Modifier.PRIVATE;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences loginPreference;
    private SharedPreferences.Editor editor;
    private EditText userName;
    private EditText password;
    private CheckBox remember;
    private Button login;
    private Button reg;
    private dbHelper Helper;

   // private Map<String,String> users=new HashMap<String,String>();//存储现有用户的信息

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Helper=new dbHelper(this);
        initView();

    }
    private void initView(){
        userName = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        remember = (CheckBox) findViewById(R.id.remember);
        login = (Button) findViewById(R.id.btn_login);
        reg=findViewById(R.id.btn_reg);
        loginPreference=getSharedPreferences("data",MODE_PRIVATE);
        editor=loginPreference.edit();
        boolean isRemember=loginPreference.getBoolean("remember_password",false);   //默认不记住密码
        if(isRemember){
            String account=loginPreference.getString("account","");
            String pwd=loginPreference.getString("password","");
            userName.setText(account);
            password.setText(pwd);
            remember.setChecked(true);
        }
        //转去注册页面
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterterActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //登录逻辑设计
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account=userName.getText().toString().trim();
                String pwd=password.getText().toString().trim();
                if(account.equals("")||pwd.equals("")){
                    Toast.makeText(LoginActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                }
                else if(!account.equals("")&&!pwd.equals("")) {
                    ArrayList<Users> data= Helper.getAllData();
                    boolean match=false;
                    for(int i=0;i<data.size();i++)
                    {
                        Users user=data.get(i);
                        if(account.equals(user.getName())&&pwd.equals(user.getPassword())){
                            match=true;
                            break;
                        }

                    }
                    if(remember.isChecked()){
                        editor.putBoolean("remember_password",true);
                        editor.putString("account",account);
                        editor.putString("password",pwd);
                        editor.apply();
                    }
                    if(match==true){
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "用户名或密码错误，登录失败", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (remember.isChecked()) {
                    loginPreference.edit().putBoolean("remeber_password", true).commit();

                }else {
                    loginPreference.edit().putBoolean("remember_password", false).commit();

                }

            }
        });

    }



}
