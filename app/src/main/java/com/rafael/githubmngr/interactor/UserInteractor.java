package com.rafael.githubmngr.interactor;

import com.rafael.githubmngr.bean.User;

public interface UserInteractor extends Interactor {

    public void getUserInfo(String token, String username, Object requestTag, InteractorCallBack<User> interactorCallBack);


}
