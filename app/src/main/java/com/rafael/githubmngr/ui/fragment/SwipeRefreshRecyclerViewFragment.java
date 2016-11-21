package com.rafael.githubmngr.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.rafael.githubmngr.R;
import com.rafael.githubmngr.bean.Entity;
import com.rafael.githubmngr.present.ui.ListUi;
import com.rafael.githubmngr.present.ui.SwipeRefreshUi;

import java.util.List;

import butterknife.Bind;

/**
 * Created by Rafael on 2016/11/4.
 */
public abstract class SwipeRefreshRecyclerViewFragment<E extends Entity> extends RecyclerViewFragment<E> implements SwipeRefreshUi<E>, ListUi<E>, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected int getAttachLayoutId() {
        return R.layout.include_refresh_recycle_view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(
                getResources().getColor(R.color.gplus_color_1),
                getResources().getColor(R.color.gplus_color_2),
                getResources().getColor(R.color.gplus_color_3),
                getResources().getColor(R.color.gplus_color_4));

    }

    @Override
    public void onRefreshSuccess(List<E> entities) {
        mSwipeRefreshLayout.setRefreshing(false);
        getRecyclerViewAdapter().setEntities(entities);
        getRecyclerViewAdapter().notifyDataSetChanged();
    }

    @Override
    public void onRefreshError(int msgId) {
        showError(msgId);
        mSwipeRefreshLayout.setRefreshing(false);
    }

}
