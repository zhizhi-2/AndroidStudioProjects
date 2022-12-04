package com.example.advancecontroldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class BaseAdapterDemoActivity extends AppCompatActivity {
    private List<Animal> mData = null;
    private Context mContext;
    private AnimalAdapter mAdapter = null;
    private ListView list_animal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter_demo);
        //1.准备Context
        mContext = BaseAdapterDemoActivity.this;

        list_animal = (ListView) findViewById(R.id.list_animal);
        //2.准备模型model
        mData = new LinkedList<Animal>();
        mData.add(new Animal("狗说", "你好?", R.mipmap.ic_launcher));
        mData.add(new Animal("牛说", "你好?", R.mipmap.ic_launcher));
        mData.add(new Animal("鸭说", "你好?", R.mipmap.ic_launcher));
        mData.add(new Animal("鱼说", "你好?", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你好?", R.mipmap.ic_launcher));
        //动态加载顶部View和底部View
        final LayoutInflater inflater = LayoutInflater.from(this);
        View headView = inflater.inflate(R.layout.view_header, null, false);
        View footView = inflater.inflate(R.layout.view_footer, null, false);

        list_animal.addHeaderView(headView);
        //list_animal.addFooterView(footView);

        //list_animal.setStackFromBottom(true);

        //3.创建adapter
        mAdapter = new AnimalAdapter((LinkedList<Animal>) mData, mContext);

        //4.设置adapter
        list_animal.setAdapter(mAdapter);
    }
}
