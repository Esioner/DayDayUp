package com.esioner.myapplication.utils;


import java.io.IOException;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtils {
    private static OkHttpUtils okHttpUtils = new OkHttpUtils();
    private static OkHttpClient mClient;

    public static OkHttpUtils getInstance() {
        return okHttpUtils;
    }

    private synchronized static OkHttpClient getClient() {
        if (mClient == null) {
            mClient = new OkHttpClient();
        }
        return mClient;
    }

    /**
     * 同步 Get 的方式请求数据
     *
     * @param url
     * @return
     * @throws IOException
     */
    public Response getResponse(String url) throws IOException {
        getClient();
        Response response;
        Request request = new Request.Builder()
                .url(url)
                .build();
        response = mClient.newCall(request).execute();
        return response;
    }

    public void asyncGet(String url, Callback callback) {
        getClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        mClient.newCall(request).enqueue(callback);
    }
}


