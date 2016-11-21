package com.rafael.githubmngr.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.rafael.githubmngr.R;

import butterknife.Bind;

/**
 * Created by Rafael on 2016/9/19.
 */
public abstract class BaseCodeHubToolBarActivity extends BaseCodeHubActivity{

    @Bind(R.id.toolbar)
    protected Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSystemBarTintColor(getResources().getColor(R.color.color_primary_dark));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        handleIntent(getIntent());
    }

    protected abstract void handleIntent(Intent intent);

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_base_codehub_toolbar;
    }

    @Override
    protected int getContentContainerViewId() {
        return R.id.base_code_hub_container;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
