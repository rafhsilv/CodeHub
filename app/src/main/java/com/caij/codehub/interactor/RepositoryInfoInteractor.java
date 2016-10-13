package com.caij.codehub.interactor;

import com.caij.codehub.bean.Repository;

public interface RepositoryInfoInteractor extends Interactor {

    public void getRepositoryInfo(String repositoryName, String owner, String token, Object requestTag, InteractorCallBack<Repository> interactorCallBack);

}
