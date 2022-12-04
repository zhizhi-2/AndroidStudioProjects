package com.example.advancecontroldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.Calendar;

public class DateTimeDemoActivity extends AppCompatActivity implements DatePicker.OnDateChangedListener, TimePicker.OnTimeChangedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_demo);
        DatePicker dp_test = (DatePicker) findViewById(R.id.dpk);
        TimePicker tpk = findViewById(R.id.tpk);
        Calendar calendar = Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int monthOfYear=calendar.get(Calendar.MONTH);
        int dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
        dp_test.init(year,monthOfYear,dayOfMonth,this);
        tpk.setOnTimeChangedListener(this);
    }

    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Toast.makeText(DateTimeDemoActivity.this,"您选择的日期是："+year+"年"+(monthOfYear+1)+"月"+dayOfMonth+"日!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        Toast.makeText(DateTimeDemoActivity.this,"您选择的时间是："+hourOfDay+"："+minute+"!",Toast.LENGTH_SHORT).show();
    }
}
