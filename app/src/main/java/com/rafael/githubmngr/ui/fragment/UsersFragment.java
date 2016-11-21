package com.rafael.githubmngr.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.rafael.githubmngr.bean.Page;
import com.rafael.githubmngr.bean.User;
import com.rafael.githubmngr.ui.activity.UserInfoActivity;
import com.rafael.githubmngr.ui.adapter.BaseAdapter;
import com.rafael.githubmngr.ui.adapter.UserAdapter;
import com.rafael.githubmngr.widgets.recyclerview.LoadMoreRecyclerView;

import java.util.List;

/**
 *
 *
 * Created by Rafael on 2016/11/18.
 */
public abstract class UsersFragment extends SwipeRefreshRecyclerViewFragment<User>{

    Page mPage;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPage = new Page();
    }

    @Override
    protected LoadMoreRecyclerView.LayoutManager createRecyclerViewLayoutManager() {
        return new LinearLayoutManager(getActivity());
    }

    @Override
    protected BaseAdapter<User> createRecyclerViewAdapter() {
        return new UserAdapter(getActivity());
    }

    @Override
    public void onItemClick(View view, int position) {
        User user =getRecyclerViewAdapter().getItem(position);
        Intent intent = UserInfoActivity.newIntent(getActivity(), user.getLogin());
        startActivity(intent);
    }

    @Override
    public void onFirstLoadSuccess(List<User> users) {
        super.onFirstLoadSuccess(users);
        mPage.next();
        getLoadMoreRecyclerView().setState(users.size() < mPage.getPageDataCount() ? LoadMoreRecyclerView.STATE_NO_MORE : LoadMoreRecyclerView.STATE_NORMAL);
    }

    @Override
    public void onRefreshSuccess(List<User> users) {
        super.onRefreshSuccess(users);
        mPage.reset();
        mPage.next();
        getLoadMoreRecyclerView().setState(users.size() < mPage.getPageDataCount() ? LoadMoreRecyclerView.STATE_NO_MORE : LoadMoreRecyclerView.STATE_NORMAL);
    }

    @Override
    public void onLoadMoreSuccess(List<User> users) {
        super.onLoadMoreSuccess(users);
        mPage.next();
        getLoadMoreRecyclerView().setState(users.size() < mPage.getPageDataCount() ? LoadMoreRecyclerView.STATE_NO_MORE : LoadMoreRecyclerView.STATE_NORMAL);
    }

}
