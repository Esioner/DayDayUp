package com.esioner.myapplication;

import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.jar.Manifest;


public class MyApplication extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

    }

    //获取 yyyyMMdd 的日期
    public static String getDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String s = sdf.format(date).trim();
        Log.e("Date", "replaceFragment: " + s);
        return s;
    }

    /**
     * 获取设备型号
     */
    public static String getDeviceModel() {
        return Build.MODEL;
    }

    /**
     * 获取手机制造商
     */
    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    /**
     * 获取当前 Unix 时间戳
     */
    public static long getUnixTime() {
        return (System.currentTimeMillis() / 1000);
    }

    /**
     * 获取屏幕宽度
     */
    public static long getScreenWidth() {
        WindowManager wm = (WindowManager) mContext.getSystemService(WINDOW_SERVICE);
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);
        int height = point.y;
        return point.x;
    }

    /**
     * 获取屏幕高度
     *
     * @return
     */
    public static long getScreenHeight() {
        WindowManager wm = (WindowManager) mContext.getSystemService(WINDOW_SERVICE);
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);
        return point.y;
    }

    //返回设备id
    public static String getDeviceId() {
        return Build.SERIAL;
    }

    /**
     * 返回版本号
     */
    public static String getVersionCode() {
        return Build.VERSION.RELEASE;
    }

    public static int getOSCode(){
        return Build.VERSION.SDK_INT;
    }
    public static int getScreenDPI(){
        WindowManager wm = (WindowManager) mContext.getSystemService(WINDOW_SERVICE);
        DisplayMetrics metric = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metric);
        return metric.densityDpi;
    }
    /**
     * 去除小数点
     */
    public static String removePoint(String str) {
        String s = str.replace(".", "");
        return s;
    }

}
