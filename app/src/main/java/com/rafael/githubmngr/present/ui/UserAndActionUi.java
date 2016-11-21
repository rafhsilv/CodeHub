package com.rafael.githubmngr.present.ui;

/**
 *
 *
 * Created by Rafael on 2016/11/16.
 */
public interface UserAndActionUi extends UserUi{

    public void onGetFollowInfoSuccess(boolean isFollow);
    public void onGetFollowInfoError(boolean isFollow);

}
