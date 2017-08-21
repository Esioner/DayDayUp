package com.esioner.myapplication;

import android.app.Application;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

    }

    //获取 yyyyMMdd 的日期
    public static String getDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String s = sdf.format(date).trim();
        Log.e("Date", "replaceFragment: " + s);
        return s;
    }
}
