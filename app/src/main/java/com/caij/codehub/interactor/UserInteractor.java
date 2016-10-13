package com.caij.codehub.interactor;

import com.caij.codehub.bean.User;

public interface UserInteractor extends Interactor {

    public void getUserInfo(String token, String username, Object requestTag, InteractorCallBack<User> interactorCallBack);


}
