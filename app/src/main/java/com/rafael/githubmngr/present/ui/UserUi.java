package com.rafael.githubmngr.present.ui;

import com.rafael.githubmngr.bean.User;

/**
 *
 *
 * Created by Rafael on 2016/11/16.
 */
public interface UserUi extends BaseUi{
    public void onGetUserInfoSuccess(User user);
}
