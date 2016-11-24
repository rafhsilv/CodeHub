package com.rafael.githubmngr.ui.activity;

import android.app.Activity;
import android.content.Intent;

import com.rafael.githubmngr.Constant;
import com.rafael.githubmngr.R;
import com.rafael.githubmngr.ui.fragment.RepoIssuesFragment;

/**
 * Created by Rafael on 2016/11/3.
 */
public class RepoIssuesActivity extends BaseGithubMngrToolBarActivity {

    public static Intent newIntent(Activity activity, String owner, String repo) {
        Intent intent = new Intent(activity, RepoIssuesActivity.class);
        intent.putExtra(Constant.USER_NAME, owner);
        intent.putExtra(Constant.REPO_NAME, repo);
        return intent;
    }

    @Override
    protected int getAttachLayoutId() {
        return 0;
    }

    @Override
    protected void handleIntent(Intent intent) {
        setTitle(getString(R.string.issue));
        String owner = getIntent().getStringExtra(Constant.USER_NAME);
        String repo = getIntent().getStringExtra(Constant.REPO_NAME);
        RepoIssuesFragment fragment = RepoIssuesFragment.newInstance(owner, repo);
        fragment.setUserVisibleHint(true);
        getSupportFragmentManager().beginTransaction().replace(R.id.base_code_hub_container, fragment).commit();
    }

}
