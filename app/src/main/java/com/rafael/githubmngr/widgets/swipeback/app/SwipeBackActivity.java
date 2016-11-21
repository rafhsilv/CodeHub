
package com.rafael.githubmngr.widgets.swipeback.app;

import android.os.Bundle;
import android.view.View;

import com.rafael.githubmngr.R;
import com.rafael.githubmngr.ui.activity.BaseActivity;
import com.rafael.githubmngr.widgets.swipeback.SwipeBackLayout;
import com.rafael.githubmngr.widgets.swipeback.Utils;

public abstract class SwipeBackActivity extends BaseActivity implements SwipeBackActivityBase {
    private SwipeBackActivityHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (isSwipeBackEnable()) {
            overridePendingTransition(R.anim.start_right_in, R.anim.start_right_out);
            mHelper = new SwipeBackActivityHelper(this);
            mHelper.onActivityCreate();
        }
        super.onCreate(savedInstanceState);
    }

    protected abstract boolean isSwipeBackEnable();

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (isSwipeBackEnable() && mHelper != null) {
            mHelper.onPostCreate();
        }
    }

    @Override
    public void finish() {
        super.finish();
        if (isSwipeBackEnable()) {
            overridePendingTransition(R.anim.finish_right_in, R.anim.finish_right_out);
        }
    }

    @Override
    public View findViewById(int id) {
        View v = super.findViewById(id);
        if (v == null && mHelper != null)
            return mHelper.findViewById(id);
        return v;
    }

    @Override
    public SwipeBackLayout getSwipeBackLayout() {
        if (mHelper != null) {
            return mHelper.getSwipeBackLayout();
        }
        return null;
    }

    @Override
    public void setSwipeBackEnable(boolean enable) {
        if (getSwipeBackLayout() != null) {
            getSwipeBackLayout().setEnableGesture(enable);
        }
    }

    @Override
    public void scrollToFinishActivity() {
        if (getSwipeBackLayout() != null) {
            Utils.convertActivityToTranslucent(this);
            getSwipeBackLayout().scrollToFinishActivity();
        }
    }

}
