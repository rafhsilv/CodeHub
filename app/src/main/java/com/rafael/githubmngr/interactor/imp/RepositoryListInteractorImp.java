package com.rafael.githubmngr.interactor.imp;

import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.reflect.TypeToken;
import com.rafael.githubmngr.API;
import com.rafael.githubmngr.bean.Page;
import com.rafael.githubmngr.bean.Repository;
import com.rafael.githubmngr.bean.SearchRepository;
import com.rafael.githubmngr.interactor.InteractorCallBack;
import com.rafael.githubmngr.interactor.RepositoryListInteractor;
import com.rafael.lib.utils.VolleyManager;
import com.rafael.lib.volley.request.GsonRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * /9/18.
 */
public class RepositoryListInteractorImp implements RepositoryListInteractor {

    @Override
    public void getUserStarredRepositories(String username, String token, Page page, Object requestTag, InteractorCallBack<List<Repository>> interactorCallBack) {
        String url = API.API_HOST + "/users/" + username + API.REPOSITORY_STARRED_URI;
        loadStarredOrUserRepository(url, token, page, requestTag, interactorCallBack);
    }

    @Override
    public void getUserRepositories(String username, String token, Page page, Object requestTag, InteractorCallBack<List<Repository>> interactorCallBack) {
        String url = API.API_HOST + "/users/" + username + API.REPOSITORY_REPOS_URI;
        loadStarredOrUserRepository(url, token, page, requestTag, interactorCallBack);
    }

    @Override
    public void getSearchRepository(String q, String sort, String order, Page page, Object requestTag, final InteractorCallBack<List<Repository>> interactorCallBack) {
        interactorCallBack.onLoading();
        Map<String, String> params = new HashMap<>();
        if (!TextUtils.isEmpty(q)) {
            params.put(API.Q, q);
        }
        if (!TextUtils.isEmpty(order)) {
            params.put(API.ORDER, order);
        }
        params.put(API.SORT, sort);
        params.put(API.PAGE, String.valueOf(page.getPageIndex()));
        params.put(API.PER_PAGE, String.valueOf(page.getPageDataCount()));
        String url = API.API_HOST + API.SEARCH_REPOSITORY_URI;
        GsonRequest<SearchRepository> request = new GsonRequest<SearchRepository>(Request.Method.GET, url, params,
                new TypeToken<SearchRepository>() {}.getType(), new Response.Listener<SearchRepository>() {
            @Override
            public void onResponse(SearchRepository response) {
                if (response != null) {
                    interactorCallBack.onSuccess(response.getItems());
                }else {
                    interactorCallBack.onError(null);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               interactorCallBack.onError(error);
            }
        });
        VolleyManager.addRequest(request, requestTag);
    }

    @Override
    public void getTrendingRepository(String since, String language, Object requestTag, final InteractorCallBack<List<Repository>> interactorCallBack) {
        interactorCallBack.onLoading();
        Map<String, String> params = new HashMap<>();
        if (!TextUtils.isEmpty(language))
            params.put(API.TENDING_REPOSITORY_PARAM_LANGUAGE, language);
        if (!TextUtils.isEmpty(since))
            params.put(API.TENDING_REPOSITORY_PARAM_SINCE, since);
        String url = API.TRENDING_REPOSITORY_HOST;
        GsonRequest<List<Repository>> request = new GsonRequest<List<Repository>>(Request.Method.GET, url, params, null,
                new TypeToken<List<Repository>>() {}.getType(), new Response.Listener<List<Repository>>() {
            @Override
            public void onResponse(List<Repository> response) {
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

    private void loadStarredOrUserRepository(String url, String token, Page page, Object requestTag, final InteractorCallBack<List<Repository>> interactorCallBack) {
        interactorCallBack.onLoading();
        Map<String, String> params = new HashMap<>();
        params.put(API.PAGE, String.valueOf(page.getPageIndex()));
        params.put(API.PER_PAGE, String.valueOf(page.getPageDataCount()));
        Map<String, String> head = new HashMap<>();
        API.configAuthorizationHead(head, token);
        GsonRequest<List<Repository>> request = new GsonRequest<List<Repository>>(Request.Method.GET, url, params, head,
                new TypeToken<List<Repository>>() {}.getType(), new Response.Listener<List<Repository>>() {
            @Override
            public void onResponse(List<Repository> response) {
                if (response != null) {
                    interactorCallBack.onSuccess(response);
                }else {
                    interactorCallBack.onError(null);
                }
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
