package com.rafael.githubmngr.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.rafael.githubmngr.R;
import com.rafael.githubmngr.bean.Entity;
import com.rafael.githubmngr.present.ui.RecyclerViewUi;
import com.rafael.githubmngr.ui.adapter.BaseAdapter;
import com.rafael.githubmngr.widgets.recyclerview.LoadMoreRecyclerView;
import com.rafael.githubmngr.widgets.recyclerview.RecyclerViewOnItemClickListener;

import java.util.List;

import butterknife.Bind;

/**
 * Created by Rafael on 2016/9/23.
 */
public abstract class RecyclerViewFragment<E extends Entity> extends LazyFragment implements LoadMoreRecyclerView.OnLoadMoreListener, RecyclerViewOnItemClickListener, RecyclerViewUi<E> {

    @Bind(R.id.recycler_view)
    LoadMoreRecyclerView mLoadMoreLoadMoreRecyclerView;
    View mEmptyView;

    private BaseAdapter<E> mRecyclerViewAdapter;

    @Override
    protected int getAttachLayoutId() {
        return R.layout.include_recycle_view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hideContentContainer();
        mRecyclerViewAdapter  = createRecyclerViewAdapter();
        mRecyclerViewAdapter.setOnItemClickListener(this);
        mLoadMoreLoadMoreRecyclerView.setLayoutManager(createRecyclerViewLayoutManager());
        mLoadMoreLoadMoreRecyclerView.setOnLoadMoreListener(this);
        mLoadMoreLoadMoreRecyclerView.setAdapter(mRecyclerViewAdapter);
    }

    protected abstract BaseAdapter<E> createRecyclerViewAdapter();

    protected abstract LoadMoreRecyclerView.LayoutManager createRecyclerViewLayoutManager();

    public BaseAdapter<E> getRecyclerViewAdapter() {
        return mRecyclerViewAdapter;
    }

    public LoadMoreRecyclerView getLoadMoreRecyclerView() {
        return mLoadMoreLoadMoreRecyclerView;
    }

    @Override
    public void showEmptyView(boolean isVisible) {
        if (isVisible) {
            if (mEmptyView == null) {
                getActivity().getLayoutInflater().inflate(R.layout.include_empty_view, mContentContainer, true);
                mEmptyView = mContentContainer.findViewById(R.id.ll_empty_view);
            }
            mEmptyView.setVisibility(View.VISIBLE);
        }else {
            if (mEmptyView != null) {
                mEmptyView.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onFirstLoadSuccess(List<E> entities) {
        showContentContainer();
        getRecyclerViewAdapter().setEntities(entities);
        getRecyclerViewAdapter().notifyDataSetChanged();
    }

    @Override
    public void onLoadMoreSuccess(List<E> entities) {
        getLoadMoreRecyclerView().completeLoading();
        getRecyclerViewAdapter().addEntities(entities);
        getRecyclerViewAdapter().notifyDataSetChanged();
    }

    @Override
    public void onFirstLoadError(int msgId) {
        showError(msgId);
    }

    @Override
    public void onLoadMoreError(int msgId) {
        showError(msgId);
        getLoadMoreRecyclerView().completeLoading();
    }

}
