package com.esioner.myapplication;

import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.esioner.myapplication.utils.LogUtil;
import com.esioner.myapplication.utils.SPUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.jar.Manifest;


public class MyApplication extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

        if (SPUtils.getString("iid").equals("")) {
            /**
             * 生成 iid
             */
            String iid = createNum(11);
            SPUtils.putString("iid", iid);
            LogUtil.d("iid", iid);
        }
        if (SPUtils.getString("uuid").equals("")) {
            /**
             * 生成 uuid
             */
            String uuid = createNum(15);
            SPUtils.putString("uuid", uuid);
            LogUtil.d("uuid", uuid);
        }
        if (SPUtils.getString("openuuid").equals("")) {
            /**
             * 生成 openuuid
             */
            String openuuid = createRandomChar();
            SPUtils.putString("openuuid", openuuid);
            LogUtil.d("openuuid", openuuid);
        }
    }

    /**
     * 获取 全局上下文
     *
     * @return
     */
    public static Context getContext() {
        return mContext;
    }

    //获取 yyyyMMdd 的日期
    public static String getDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String s = sdf.format(date).trim();
        LogUtil.d("DATE", s);
        return s;
    }

    /**
     * 获取设备型号
     */
    public static String getDeviceModel() {
        LogUtil.d("DEVICE_MODEL", Build.MODEL);
        return Build.MODEL;

    }

    /**
     * 获取手机制造商
     */
    public static String getManufacturer() {
        LogUtil.d("Manufacturer", Build.MANUFACTURER);
        return Build.MANUFACTURER;
    }

    /**
     * 获取当前 Unix 时间戳
     */
    public static long getUnixTime() {
        LogUtil.d("UnixTime", (System.currentTimeMillis()) + "");
        return (System.currentTimeMillis());
    }

    /**
     * 获取屏幕宽度
     */
    public static long getScreenWidth() {
        WindowManager wm = (WindowManager) mContext.getSystemService(WINDOW_SERVICE);
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);
        int height = point.y;

        LogUtil.d("WIDTH*HEIGHT", point.x * point.y + "");

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
        LogUtil.d("getDeviceId", Build.SERIAL);
        return Build.SERIAL;
    }

    /**
     * 返回版本号
     */
    public static String getVersionCode() {
        LogUtil.d("getVersionCode", Build.VERSION.RELEASE);
        return Build.VERSION.RELEASE;
    }

    public static int getOSCode() {
        LogUtil.d("getOSCode", Build.VERSION.SDK_INT + "");
        return Build.VERSION.SDK_INT;
    }

    public static int getScreenDPI() {
        WindowManager wm = (WindowManager) mContext.getSystemService(WINDOW_SERVICE);
        DisplayMetrics metric = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metric);
        LogUtil.d("getScreenDPI", metric.densityDpi + "");
        return metric.densityDpi;
    }

    /**
     * 去除小数点
     */
    public static String removePoint(String str) {
        String s = str.replace(".", "");
        return s;
    }

    /**
     * 生成 iid ： 11 位纯数字
     */
    public String createNum(int b) {
        String s = "";
        for (int i = 0; i < b; i++) {
            int a = (int) (Math.random() * 10);
            s = s + a;
        }
        return s;
    }

    public String createRandomChar() {
        String[] strings = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
                "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4",
                "5", "6", "7", "8", "9", "0"};
        Random r = new Random();
        String s = "";
        String temp = "";
        for (int i = 0; i < 16; i++) {
            temp = strings[r.nextInt(36)];
            s = s + temp;
        }
        return s;
    }

}
