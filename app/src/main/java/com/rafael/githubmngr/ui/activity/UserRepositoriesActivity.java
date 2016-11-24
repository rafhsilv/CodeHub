package com.rafael.githubmngr.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.rafael.githubmngr.Constant;
import com.rafael.githubmngr.R;
import com.rafael.githubmngr.ui.fragment.UserRepositoriesFragment;


/**
 * Created by Rafael on 2016/9/24.
 */
public class UserRepositoriesActivity extends BaseGithubMngrToolBarActivity {


    public static Intent newIntent(Activity activity, String username) {
        Intent intent = new Intent(activity, UserRepositoriesActivity.class);
        intent.putExtra(Constant.USER_NAME, username);
        return intent;
    }

    @Override
    protected void handleIntent(Intent intent) {
        String username = intent.getStringExtra(Constant.USER_NAME);
        setTitle(username);
        Fragment fragment =  UserRepositoriesFragment.newInstance(username);
        fragment.setUserVisibleHint(true);
        getSupportFragmentManager().beginTransaction().add(R.id.base_code_hub_container, fragment).commit();
    }

    @Override
    protected int getAttachLayoutId() {
        return 0;
    }

}
