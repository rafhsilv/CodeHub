package com.rafael.githubmngr.interactor.imp;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.reflect.TypeToken;
import com.rafael.githubmngr.API;
import com.rafael.githubmngr.bean.User;
import com.rafael.githubmngr.interactor.InteractorCallBack;
import com.rafael.githubmngr.interactor.UserInteractor;
import com.rafael.lib.utils.VolleyManager;
import com.rafael.lib.volley.request.GsonRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * /9/18.
 */
public class UserInteractorImp implements UserInteractor {

    @Override
    public void getUserInfo(String token, String username, Object requestTag, final InteractorCallBack<User> interactorCallBack) {
        interactorCallBack.onLoading();
        String url = API.API_HOST + "/users/" + username;
        Map<String, String> head = new HashMap<>();
        API.configAuthorizationHead(head, token);
        GsonRequest<User> request = new GsonRequest<User>(Request.Method.GET, url, "", head, new TypeToken<User>() {}.getType(),new Response.Listener<User>() {
            @Override
            public void onResponse(User response) {
                interactorCallBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                interactorCallBack.onError(error);
            }
        });
        VolleyManager.addRequest(request, requestTag);
    }
}
