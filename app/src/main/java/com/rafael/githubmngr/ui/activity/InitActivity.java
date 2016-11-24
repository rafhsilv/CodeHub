package com.rafael.githubmngr.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;

import com.rafael.githubmngr.GithubMngrPrefs;
import com.rafael.githubmngr.R;

public class InitActivity extends BaseGithubMngrActivity {

    public static final long SKIP_DELAY_TIME = 3000;

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullScreen();
        mHandler = new Handler();
    }

    @Override
    protected int getAttachLayoutId() {
        return R.layout.activity_init;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                if (TextUtils.isEmpty(GithubMngrPrefs.get().getToken())) {
                    intent = new Intent(InitActivity.this, LoginActivity.class);
                } else {
                    intent = new Intent(InitActivity.this, MainActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }, SKIP_DELAY_TIME);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mHandler.removeCallbacksAndMessages(null);
    }
}
