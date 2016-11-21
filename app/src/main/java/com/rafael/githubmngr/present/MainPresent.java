package com.rafael.githubmngr.present;

import com.rafael.githubmngr.bean.User;
import com.rafael.githubmngr.interactor.InteractorFactory;
import com.rafael.githubmngr.interactor.UserInteractor;
import com.rafael.githubmngr.present.ui.MainUi;

/**
 *
 *
 * Created by Rafael on 2016/11/16.
 */
public class MainPresent extends Present<MainUi>{

    protected final UserInteractor mUserInterctor;

    public MainPresent(MainUi ui) {
        super(ui);
        mUserInterctor = InteractorFactory.newInteractorInstance(UserInteractor.class);
    }

    public void getUserInfo(String token, String username) {
        mUserInterctor.getUserInfo(token, username, this, new DefaultInteractorCallback<User>(mUi) {
            @Override
            public void onSuccess(User user) {
                mUi.onGetUserInfoSuccess(user);
            }

            @Override
            public void onLoading() {

            }

            @Override
            public void onError(int msgId) {
                mUi.showError(msgId);
            }
        });
    }

}
