package com.rafael.githubmngr.present.ui;

import java.util.List;

public interface SwipeRefreshUi<E> extends BaseUi{

    void onRefreshSuccess(List<E> entities);

    void onRefreshError(int msgId);
}
