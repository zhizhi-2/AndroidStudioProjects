package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterterActivity extends AppCompatActivity {
private EditText edit_name;
private EditText edit_password1;
private EditText edit_password2;
private Button btn_register;
public dbHelper Helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerter);
        Helper=new dbHelper(this);
        initView();
    }
    public void initView() {

        edit_name = findViewById(R.id.edit_name);
        edit_password1 = findViewById(R.id.edit_password1);
        edit_password2 = findViewById(R.id.edit_password2);
        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=edit_name.getText().toString();
                String password1=edit_password1.getText().toString();
                String password2=edit_password2.getText().toString();
                if(!username.equals("")&&!password1.equals("")&&!password2.equals(""))
                {
                    if(password1.equals(password2))
                    {
                        Helper.add(username,password1);
                        Intent intent1=new Intent(RegisterterActivity.this,LoginActivity.class);
                        startActivity(intent1);
                        Toast.makeText(RegisterterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(RegisterterActivity.this, "密码设置错误，注册失败", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(RegisterterActivity.this, "未完善信息，注册失败", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
