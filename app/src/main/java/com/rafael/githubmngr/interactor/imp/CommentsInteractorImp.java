package com.rafael.githubmngr.interactor.imp;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.reflect.TypeToken;
import com.rafael.githubmngr.API;
import com.rafael.githubmngr.bean.Comment;
import com.rafael.githubmngr.interactor.CommentsInteractor;
import com.rafael.githubmngr.interactor.InteractorCallBack;
import com.rafael.lib.utils.VolleyManager;
import com.rafael.lib.volley.request.GsonRequest;

import java.util.List;

public class CommentsInteractorImp implements CommentsInteractor {


    @Override
    public void getIssuesComments(String owner, String repo, String issueNumber, Object requestTag, final InteractorCallBack<List<Comment>> interactorCallBack) {
        interactorCallBack.onLoading();
        String url = new StringBuilder().append(API.API_HOST).append("/repos/")
                .append(owner).append("/").append(repo).append("/issues/")
                .append(issueNumber).append("/comments").toString();
        GsonRequest<List<Comment>> request = new GsonRequest<List<Comment>>(Request.Method.GET, url, new TypeToken<List<Comment>>() {
        }.getType(),
                new Response.Listener<List<Comment>>() {
                    @Override
                    public void onResponse(List<Comment> response) {
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
