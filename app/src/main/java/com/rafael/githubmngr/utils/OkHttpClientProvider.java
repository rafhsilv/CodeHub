package com.rafael.githubmngr.utils;

import com.rafael.lib.utils.LogUtil;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;

/**
 * Created by Rafael on 2016/10/30.
 */
public class OkHttpClientProvider {

    private static final String TAG = "OkHttpClientProvider";

    private static OkHttpClient mOkHttpClient;

    public static OkHttpClient getOkHttpClient() {
        if (mOkHttpClient == null) {
            mOkHttpClient = new OkHttpClient();
            try {
                // only debug use
                Class c = Class.forName("com.facebook.stetho.okhttp.StethoInterceptor");
                mOkHttpClient.networkInterceptors().add((Interceptor) c.newInstance());
            } catch (Exception e) {
                LogUtil.e(TAG, "com.facebook.stetho.okhttp.StethoInterceptor not found");
            }
        }
        return mOkHttpClient;
    }

}
