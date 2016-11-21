package com.rafael.githubmngr.interactor;

import com.rafael.githubmngr.bean.Page;
import com.rafael.githubmngr.bean.Repository;

import java.util.List;

public interface RepositoryListInteractor extends Interactor {

    public void getUserStarredRepositories(String username, String token, Page page, Object requestTag, InteractorCallBack<List<Repository>> interactorCallBack);

    public void getUserRepositories(String username, String token, Page page, Object requestTag, InteractorCallBack<List<Repository>> interactorCallBack);

    public void getSearchRepository(String q, String sort, String order, Page page, Object requestTag, InteractorCallBack<List<Repository>> interactorCallBack);

    public void getTrendingRepository(String since, String language,Object requestTag, InteractorCallBack<List<Repository>> interactorCallBack);

}
