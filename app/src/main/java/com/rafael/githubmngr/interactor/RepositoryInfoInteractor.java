package com.rafael.githubmngr.interactor;

import com.rafael.githubmngr.bean.Repository;

public interface RepositoryInfoInteractor extends Interactor {

    public void getRepositoryInfo(String repositoryName, String owner, String token, Object requestTag, InteractorCallBack<Repository> interactorCallBack);

}
