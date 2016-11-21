package com.rafael.githubmngr.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.rafael.githubmngr.R;
import com.rafael.githubmngr.bean.Page;
import com.rafael.githubmngr.bean.Repository;
import com.rafael.githubmngr.ui.activity.RepositoryInfoActivity;
import com.rafael.githubmngr.ui.adapter.BaseAdapter;
import com.rafael.githubmngr.ui.adapter.RepositoryAdapter;
import com.rafael.githubmngr.widgets.recyclerview.LoadMoreRecyclerView;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.List;

/**
 * Created by Rafael on 2016/9/18.
 */
public abstract class RepositoriesFragment extends SwipeRefreshRecyclerViewFragment<Repository> {

    protected Page mPage;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPage = new Page();
        getLoadMoreRecyclerView().addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(getActivity()).color(getResources().getColor(R.color.divider))
                        .size(getResources().getDimensionPixelSize(R.dimen.divider))
                        .margin(getResources().getDimensionPixelSize(R.dimen.repository_divider_margin_left),
                                getResources().getDimensionPixelSize(R.dimen.small_margin)).build());
    }

    @Override
    protected BaseAdapter<Repository> createRecyclerViewAdapter() {
        return new RepositoryAdapter(getActivity());
    }

    @Override
    protected LoadMoreRecyclerView.LayoutManager createRecyclerViewLayoutManager() {
        return new LinearLayoutManager(getActivity());
    }

    @Override
    public void onItemClick(View view, int position) {
        Repository repository = getRecyclerViewAdapter().getItem(position);
        Intent intent = RepositoryInfoActivity.newInstance(getActivity(),
                repository.getOwner().getLogin(), repository.getName());
        startActivity(intent);
    }

    @Override
    public void onFirstLoadSuccess(List<Repository> repositories) {
        super.onFirstLoadSuccess(repositories);
        mPage.reset();
        mPage.next();
        getLoadMoreRecyclerView().setState(repositories.size() < mPage.getPageDataCount() ? LoadMoreRecyclerView.STATE_NO_MORE : LoadMoreRecyclerView.STATE_NORMAL);
    }

    @Override
    public void onRefreshSuccess(List<Repository> repositories) {
        super.onRefreshSuccess(repositories);
        mPage.reset();
        mPage.next();
        getLoadMoreRecyclerView().setState(repositories.size() < mPage.getPageDataCount() ? LoadMoreRecyclerView.STATE_NO_MORE : LoadMoreRecyclerView.STATE_NORMAL);
    }

    @Override
    public void onLoadMoreSuccess(List<Repository> repositories) {
        super.onLoadMoreSuccess(repositories);
        mPage.next();
        getLoadMoreRecyclerView().setState(repositories.size() < mPage.getPageDataCount() ? LoadMoreRecyclerView.STATE_NO_MORE : LoadMoreRecyclerView.STATE_NORMAL);
    }
}
