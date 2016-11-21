package com.rafael.githubmngr.ui.activity;

import android.app.Activity;
import android.content.Intent;

import com.rafael.githubmngr.Constant;
import com.rafael.githubmngr.R;
import com.rafael.githubmngr.bean.FileTreeItem;
import com.rafael.githubmngr.ui.fragment.FileTreeFragment;
import com.rafael.githubmngr.widgets.LinearBreadcrumb;
import com.rafael.lib.utils.LogUtil;

import butterknife.Bind;

/**
 * Created by Rafael on 2016/11/2.
 */
public class FileTreeActivity extends BaseCodeHubToolBarActivity implements LinearBreadcrumb.SelectionCallback, FileTreeFragment.LinearBreadcrumbInterface {

    private static final String TAG = "FileTreeActivity";
    @Bind(R.id.bread_crumbs)
    LinearBreadcrumb breadCrumbs;
    private String mOwner;
    private String mRepoName;
    private String mBran;

    public static Intent newIntent(Activity activity, String owner, String repo, String bran) {
        Intent intent = new Intent(activity, FileTreeActivity.class);
        intent.putExtra(Constant.USER_NAME, owner);
        intent.putExtra(Constant.REPO_NAME, repo);
        intent.putExtra(Constant.REPO_BRAN, bran);
        return intent;
    }

    @Override
    protected int getAttachLayoutId() {
        return R.layout.activity_file_tree;
    }

    @Override
    protected void handleIntent(Intent intent) {
        setTitle(getString(R.string.source));
        breadCrumbs.setCallback(this);

        mOwner = intent.getStringExtra(Constant.USER_NAME);
        mRepoName = intent.getStringExtra(Constant.REPO_NAME);
        mBran = intent.getStringExtra(Constant.REPO_BRAN);
        breadCrumbs.addCrumb(new LinearBreadcrumb.Crumb(mBran, mBran), true);
        FileTreeFragment fragment = FileTreeFragment.newInstance(mOwner, mRepoName, mBran);
        fragment.setUserVisibleHint(true);
        getSupportFragmentManager().beginTransaction().add(R.id.fl_file_tree, fragment, mBran).commit();

    }

    @Override
    public String getAbsolutePath() {
        return breadCrumbs.getAbsolutePath(breadCrumbs.getCrumb(breadCrumbs.size() - 1),"/");
    }

    @Override
    public void onCrumbSelection(LinearBreadcrumb.Crumb crumb, String absolutePath, int count, int index) {
        LogUtil.i(TAG, "crumb = " + crumb);
        LogUtil.i(TAG, "absolutePath = " + absolutePath);
        LogUtil.i(TAG, "count = " + count);
        LogUtil.i(TAG, "index = " + index);
        LinearBreadcrumb.Crumb indexCrumb;
        for (int i = index + 1; i < count; i++) {
            onBackPressed();
        }
    }


    @Override
    public void intoItem(FileTreeItem item) {
        breadCrumbs.addCrumb(new LinearBreadcrumb.Crumb(item.getPath(), item.getSha()), true);
        String sha = item.getSha();
        FileTreeFragment fileTreeFragment = FileTreeFragment.newInstance(mOwner, mRepoName, sha);
        fileTreeFragment.setUserVisibleHint(true);
        getSupportFragmentManager().beginTransaction().add(R.id.fl_file_tree, fileTreeFragment, sha).addToBackStack(sha).commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (breadCrumbs.size() > 1) {
            breadCrumbs.removeCrumbAt(breadCrumbs.size() - 1);
            breadCrumbs.setActive(breadCrumbs.size() - 1);
        }
    }
}


