package com.rafael.githubmngr.present.ui;

/**
 * Created by Rafael on 2016/11/16.
 */
public interface BaseUi {

    public void onAuthError();

    public void showContentAnimLoading(boolean isVisible);

    public void showError(int msgId);

    public void showContentError();

    public void showProgressBarLoading(boolean isVisible);

}
