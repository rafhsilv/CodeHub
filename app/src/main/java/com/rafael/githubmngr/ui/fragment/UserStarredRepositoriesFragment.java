package com.rafael.githubmngr.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.rafael.githubmngr.GithubMngrPrefs;
import com.rafael.githubmngr.Constant;
import com.rafael.githubmngr.present.LoadType;
import com.rafael.githubmngr.present.RepositoriesPresent;
import com.rafael.lib.utils.CheckValueUtil;


/**
 * Created by Rafael on 2016/9/21.
 */
public class UserStarredRepositoriesFragment extends RepositoriesFragment {

    protected String mUsername;
    protected String mToken;
    private RepositoriesPresent mRepositoriesPresent;

    public static RepositoriesFragment newInstance(String username) {
        CheckValueUtil.check(username);
        Bundle bundle = new Bundle();
        bundle.putString(Constant.USER_NAME, username);
        RepositoriesFragment fragment = new UserStarredRepositoriesFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUsername = getArguments().getString(Constant.USER_NAME);
        mToken = GithubMngrPrefs.get().getToken();
        mRepositoriesPresent = new RepositoriesPresent(this);
    }

    @Override
    protected void onUserFirstVisible() {
        mRepositoriesPresent.getUserStarredRepositories(LoadType.FIRST, mUsername, mToken, mPage);
    }

    @Override
    public void onRefresh() {
        mRepositoriesPresent.getUserStarredRepositories(LoadType.REFRESH, mUsername, mToken,  mPage.createRefreshPage());
    }

    @Override
    public void onReFreshBtnClick(View view) {
        super.onReFreshBtnClick(view);
        mRepositoriesPresent.getUserStarredRepositories(LoadType.FIRST, mUsername, mToken,  mPage);
    }

    @Override
    public void onLoadMore() {
        mRepositoriesPresent.getUserStarredRepositories(LoadType.LOADMORE, mUsername, mToken, mPage);
    }

    @Override
    public void onDestroyView() {
        mRepositoriesPresent.onDeath();
        super.onDestroyView();
    }
}
