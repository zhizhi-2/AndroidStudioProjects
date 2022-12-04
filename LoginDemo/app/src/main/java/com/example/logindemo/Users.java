package com.example.logindemo;
//定义一个用户类，用来描述用户的相关信息
public class Users {
    String name;
    String password;
    public Users(String name,String password)
    {
        this.name=name;
        this.password=password;
    }
    String getName()
    {
        return name;
    }
    void setName(String name)
    {
        this.name=name;
    }

    String getPassword()
    {
        return password;
    }
    void setPassword(String password)
    {
        this.password=password;
    }
   public String toString()
   {
        return "Users{"+"name='"+name+'\''+
                ",password-'"+password+'\''+
                '}';
    }

}
