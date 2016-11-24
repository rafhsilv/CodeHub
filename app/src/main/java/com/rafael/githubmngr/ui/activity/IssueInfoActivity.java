package com.rafael.githubmngr.ui.activity;

import android.app.Activity;
import android.content.Intent;

import com.rafael.githubmngr.Constant;
import com.rafael.githubmngr.R;
import com.rafael.githubmngr.ui.fragment.IssueInfoFragment;


/**
 * Created by Rafael on 2016/10/31.
 */
public class IssueInfoActivity extends BaseGithubMngrToolBarActivity {

    public static Intent newIntent(Activity activity, String owner, String repo, String issueNumber, String issueTitle, String issueBody) {
        Intent intent = new Intent(activity, IssueInfoActivity.class);
        intent.putExtra(Constant.REPO_NAME, repo);
        intent.putExtra(Constant.USER_NAME, owner);
        intent.putExtra(Constant.ISSUE_NUMBER, issueNumber);
        intent.putExtra(Constant.ISSUE_TITLE, issueTitle);
        intent.putExtra(Constant.ISSUE_BODY, issueBody);
        return intent;
    }

    @Override
    protected void handleIntent(Intent intent) {
        String repoName = intent.getStringExtra(Constant.REPO_NAME);
        String issueNumber = intent.getStringExtra(Constant.ISSUE_NUMBER);

        setTitle(repoName + "  #" + issueNumber);

        IssueInfoFragment fragment = IssueInfoFragment.newInstance(intent.getStringExtra(Constant.USER_NAME), repoName,
                issueNumber, intent.getStringExtra(Constant.ISSUE_TITLE), intent.getStringExtra(Constant.ISSUE_BODY));
        fragment.setUserVisibleHint(true);
        getSupportFragmentManager().beginTransaction().replace(R.id.base_code_hub_container, fragment).commit();
    }

    @Override
    protected int getAttachLayoutId() {
        return 0;
    }

}
