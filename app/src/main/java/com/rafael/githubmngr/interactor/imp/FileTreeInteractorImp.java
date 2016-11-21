package com.rafael.githubmngr.interactor.imp;

import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.reflect.TypeToken;
import com.rafael.githubmngr.API;
import com.rafael.githubmngr.bean.Tree;
import com.rafael.githubmngr.interactor.FileTreeInteractor;
import com.rafael.githubmngr.interactor.InteractorCallBack;
import com.rafael.lib.utils.VolleyManager;
import com.rafael.lib.volley.request.GsonRequest;

/**
 * /11/2.
 */
public class FileTreeInteractorImp implements FileTreeInteractor {

    @Override
    public void loadFileTree(String name, String repo, String ref,  Object requestTag, final InteractorCallBack<Tree> interactorCallBack) {
        interactorCallBack.onLoading();
        StringBuilder builder = new StringBuilder();
        builder.append(API.API_HOST).append("/repos/").append(name).append("/").
                append(repo).append("/git/trees/");
        if (!TextUtils.isEmpty(ref)) {
            builder.append(ref);
        }
        String url = builder.toString();
                GsonRequest<Tree> request = new GsonRequest<Tree>(Request.Method.GET, url, new TypeToken<Tree>() {
        }.getType(), new Response.Listener<Tree>() {
            @Override
            public void onResponse(Tree response) {
                interactorCallBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                interactorCallBack.onError(error);
            }
        });
        VolleyManager.addRequest(request, null);
    }

}
