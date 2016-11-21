package com.rafael.githubmngr.present.ui;

/**
 *
 *
 * Created by Rafael on 2016/11/16.
 */
public interface UserInfoUi extends UserUi{

    public void onGetFollowStateSuccess(boolean isFollow);
    public void onFollowSuccess();
    public void onUnfollowSuccess();

}
