package com.esioner.myapplication.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.esioner.myapplication.MyApplication;

/**
 * Create: 2017/8/22
 * Writer: liurui
 * Phone:  13554142421
 * Email:  16801630@qq.com
 */

public class SPUtils {
    public static SharedPreferences sp;

    public static SharedPreferences getInstance() {
        if (sp == null) {
            sp = MyApplication.getContext().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        }
        return sp;
    }

    /**
     * 存入 string
     *
     * @param key
     * @param value
     */
    public static void putString(String key, String value) {
        getInstance();
        sp.edit().putString(key, value).apply();
    }

    /**
     * 读取 string
     */
    public static String getString(String key) {
        getInstance();
        return sp.getString(key, "");
    }
}
