package com.rafael.githubmngr.present;

import com.android.volley.NetworkResponse;
import com.rafael.githubmngr.interactor.AuthenticationInteractor;
import com.rafael.githubmngr.interactor.InteractorFactory;
import com.rafael.githubmngr.present.ui.SettingUi;


public class SettingPresent extends Present<SettingUi>{

    private final AuthenticationInteractor mAuthenticationInteractor;

    public SettingPresent(SettingUi ui) {
        super(ui);
        mAuthenticationInteractor = InteractorFactory.newInteractorInstance(AuthenticationInteractor.class);
    }

    public void logout(String base64UsernameAndPwd, String tokenId){
        mAuthenticationInteractor.logout(base64UsernameAndPwd, tokenId, this, new DefaultInteractorCallback<NetworkResponse>(mUi) {
            @Override
            public void onError(int msgId) {
                mUi.showLogoutLoading(false);
                mUi.showError(msgId);
            }

            @Override
            public void onSuccess(NetworkResponse response) {
                mUi.showLogoutLoading(false);
                mUi.logoutSuccess();
            }

            @Override
            public void onLoading() {
                mUi.showLogoutLoading(true);
            }
        });
    }
}
