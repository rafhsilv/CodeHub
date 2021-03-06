package com.rafael.githubmngr.present;

import com.rafael.githubmngr.bean.Entity;
import com.rafael.githubmngr.present.ui.ListUi;

import java.util.List;

/**
 *
 *
 * Created by Rafael on 2016/11/16.
 */
public abstract class ListPresent<UI extends ListUi<E>, E extends Entity> extends Present<UI>{

    public ListPresent(UI ui) {
        super(ui);
    }

    protected void defaultDealWithError(int msgId, LoadType loadType) {
        switch (loadType) {
            case FIRST:
                mUi.showContentAnimLoading(false);
                mUi.showContentError();
                mUi.onFirstLoadError(msgId);
                break;

            case REFRESH:
                mUi.onRefreshError(msgId);
                break;

            case LOADMORE:
                mUi.onLoadMoreError(msgId);
                break;
        }
    }

    protected void defaultDealWithSuccess(List<E> entities, LoadType loadType) {
        switch (loadType) {
            case FIRST:
                mUi.showContentAnimLoading(false);
                mUi.onFirstLoadSuccess(entities);
                if (entities == null || entities.size() == 0) {
                    mUi.showEmptyView(true);
                } else {
                    mUi.showEmptyView(false);
                }
                break;

            case REFRESH:
                mUi.onRefreshSuccess(entities);
                if (entities == null || entities.size() == 0) {
                    mUi.showEmptyView(true);
                } else {
                    mUi.showEmptyView(false);
                }
                break;

            case LOADMORE:
                mUi.onLoadMoreSuccess(entities);
                break;
        }
    }

    protected void defaultDealWithLoading(LoadType loadType) {
        switch (loadType) {
            case FIRST:
                mUi.showContentAnimLoading(true);
                break;

            case REFRESH:
                break;

            case LOADMORE:
                break;
        }
    }
}
