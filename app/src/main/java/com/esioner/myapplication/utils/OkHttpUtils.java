package com.esioner.myapplication.utils;


import java.io.IOException;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtils {
    private static OkHttpClient mClient;

    public static synchronized OkHttpClient getInstance() {
        if (mClient == null) {
            mClient = new OkHttpClient();
        }
        return mClient;
    }

    /**
     * 同步 Get 的方式请求数据
     * @param url
     * @return
     * @throws IOException
     */
    public static Response getResponse(String url) throws IOException {
        getInstance();
        Response response;
        Request request = new Request.Builder()
                .url(url)
                .build();
        response = mClient.newCall(request).execute();
        return response;
    }

    public static void asyncGet(String url, Callback callback){
        getInstance();
        Request request = new Request.Builder()
                .url(url)
                .build();
        mClient.newCall(request).enqueue(callback);
    }
}


