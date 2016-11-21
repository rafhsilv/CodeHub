package com.rafael.githubmngr;

import android.app.Application;

import com.rafael.githubmngr.utils.OkHttpClientProvider;
import com.rafael.lib.utils.LogUtil;
import com.rafael.lib.utils.SPUtils;
import com.rafael.lib.utils.VolleyManager;
import com.rafael.lib.volley.stack.OkHttpStack;

public class GithubMngrApplication extends Application{

    private static final String SP_FILE_NAME = "profile";

    private static final int VOLLEY_DISK_MAX_SIZE = 1024 * 1024 * 5;

    @Override
    public void onCreate() {
        super.onCreate();
        SPUtils.init(this, SP_FILE_NAME);
        LogUtil.LOG_DEBUG = BuildConfig.LOG_DEBUG;
        VolleyManager.init(this, new OkHttpStack(OkHttpClientProvider.getOkHttpClient()), VOLLEY_DISK_MAX_SIZE);
    }

}
