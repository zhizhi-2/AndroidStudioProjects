package com.example.logindemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class dbHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;

    //构造函数
    public dbHelper(Context context ) {
        super(context, "db_test", null, 1);
         db=getReadableDatabase();  //获得可读的数据库
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table if not exists users("+
                " id integer primary key autoincrement,"+
                "name String,"+
                "password String)");  //建一个用户表，里面包含 id,nmae,passsword这三个字段
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
        onCreate(db);
    }

    //向表中插入数据
    public void add(String name,String password){
        db.execSQL("insert into users (name,password) values(?,?)",new Object[]{name,password});
    }
    //删除表中的数据
    public void delete(String name,String password){
           db.execSQL("delete from users where name= and password="+name+password);
    }
    //修改表中的数据
    public void updata(String password){
        db.execSQL("update users set password=?",new Object[]{password});
    }

    //把数据库中的数据取出存到哈希表中
    public ArrayList<Users> getAllData(){
        ArrayList<Users> list=new ArrayList<>();
        Cursor cursor=db.query("users",null,null,null,null,null,"name DESC");
                while(cursor.moveToNext()){
                    String name=cursor.getString(cursor.getColumnIndex("name"));
                    String password=cursor.getString(cursor.getColumnIndex("password"));
                    list.add(new Users(name,password));
                }
                return list;
    }


}
