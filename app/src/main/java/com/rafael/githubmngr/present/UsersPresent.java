package com.rafael.githubmngr.present;

import com.rafael.githubmngr.bean.Page;
import com.rafael.githubmngr.bean.User;
import com.rafael.githubmngr.interactor.InteractorFactory;
import com.rafael.githubmngr.interactor.UserListInteractor;
import com.rafael.githubmngr.present.ui.ListUi;

import java.util.List;

public class UsersPresent extends ListPresent<ListUi<User>, User>{

    private UserListInteractor mUserListInteractor;

    public UsersPresent(ListUi<User> ui) {
        super(ui);
        mUserListInteractor = InteractorFactory.newInteractorInstance(UserListInteractor.class);
    }

    public void getFollowers(final LoadType loadType, String token, String username, Page page) {
        mUserListInteractor.getFollowers(token, username, page, this, new DefaultInteractorCallback<List<User>>(mUi) {
            @Override
            public void onError(int msgId) {
                defaultDealWithError(msgId, loadType);
            }

            @Override
            public void onSuccess(List<User> users) {
                defaultDealWithSuccess(users, loadType);
            }

            @Override
            public void onLoading() {
                defaultDealWithLoading(loadType);
            }
        });
    }

    public void getFollowing(final LoadType loadType, String token, String username, Page page){
        mUserListInteractor.getFollowing(token, username, page, this, new DefaultInteractorCallback<List<User>>(mUi) {
            @Override
            public void onError(int msgId) {
                defaultDealWithError(msgId, loadType);
            }

            @Override
            public void onSuccess(List<User> users) {
                defaultDealWithSuccess(users, loadType);
            }

            @Override
            public void onLoading() {
                defaultDealWithLoading(loadType);
            }
        });
    }
}
