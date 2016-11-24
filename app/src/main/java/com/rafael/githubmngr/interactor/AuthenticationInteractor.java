package com.rafael.githubmngr.interactor;

import com.android.volley.NetworkResponse;
import com.rafael.githubmngr.bean.Token;

import java.util.List;

/**
 * /8/25.
 */
public interface AuthenticationInteractor extends Interactor {
    void login(String username, String pwd, Object requestTag, InteractorCallBack<Token> interactorCallBack);

    void logout(String base64UsernameAndPwd, String tokenId, Object requestTag, InteractorCallBack<NetworkResponse> interactorCallBack);

    void getHaveTokens(final String username, final String pwd, Object requestTag, final InteractorCallBack<List<Token>> interactorCallBack);

}
