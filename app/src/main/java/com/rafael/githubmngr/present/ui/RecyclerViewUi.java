package com.rafael.githubmngr.present.ui;

import java.util.List;

public interface RecyclerViewUi<E> extends BaseUi{

    void onFirstLoadSuccess(List<E> entities);

    void onFirstLoadError(int msgId);

    void onLoadMoreSuccess(List<E> entities);

    void onLoadMoreError(int msgId);

    void showEmptyView(boolean isVisible);
}
