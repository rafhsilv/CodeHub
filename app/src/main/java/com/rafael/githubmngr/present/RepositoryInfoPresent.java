package com.rafael.githubmngr.present;

import com.android.volley.NetworkResponse;
import com.rafael.githubmngr.bean.Repository;
import com.rafael.githubmngr.interactor.InteractorFactory;
import com.rafael.githubmngr.interactor.RepositoryActionInteractor;
import com.rafael.githubmngr.interactor.RepositoryInfoInteractor;
import com.rafael.githubmngr.present.ui.RepositoryInfoUi;

/**
 *
 *
 * Created by Rafael on 2016/11/16.
 */
public class RepositoryInfoPresent extends Present<RepositoryInfoUi>{

    public final RepositoryInfoInteractor mRepositoryInfoInteractor;
    public final RepositoryActionInteractor mRepositoryActionInteractor;

    public RepositoryInfoPresent(RepositoryInfoUi ui) {
        super(ui);
        mRepositoryInfoInteractor = InteractorFactory.newInteractorInstance(RepositoryInfoInteractor.class);
        mRepositoryActionInteractor = InteractorFactory.newInteractorInstance(RepositoryActionInteractor.class);
    }

    public void getRepositoryInfo(String repositoryName, String owner, String token) {
        mRepositoryInfoInteractor.getRepositoryInfo(repositoryName, owner, token, this, new DefaultInteractorCallback<Repository>(mUi) {
            @Override
            public void onError(int msgId) {
                mUi.showContentAnimLoading(false);
                mUi.showError(msgId);
                mUi.showContentError();
            }

            @Override
            public void onSuccess(Repository repository) {
                mUi.showContentAnimLoading(false);
                mUi.getRepositoryInfoSuccess(repository);
            }

            @Override
            public void onLoading() {
                mUi.showContentAnimLoading(true);
            }
        });
    }

    public void hasStarRepo(String owner, String repo, String token){
        mRepositoryActionInteractor.hasStarRepo(owner, repo, token, this, new DefaultInteractorCallback<Boolean>(mUi) {
            @Override
            public void onError(int msgId) {

            }

            @Override
            public void onSuccess(Boolean aBoolean) {
                mUi.getStarStateSuccess(aBoolean);
            }

            @Override
            public void onLoading() {

            }
        });
    }

    public void starRepo(String owner, String repo, String token){
        mRepositoryActionInteractor.starRepo(owner, repo, token, this, new DefaultInteractorCallback<NetworkResponse>(mUi) {
            @Override
            public void onSuccess(NetworkResponse response) {
                mUi.showProgressBarLoading(false);
                mUi.starSuccess();
            }

            @Override
            public void onLoading() {
                mUi.showProgressBarLoading(true);
            }

            @Override
            public void onError(int msgId) {
                mUi.showProgressBarLoading(false);
                mUi.showError(msgId);
            }
        });
    }

    public void unstarRepo(String owner, String repo, String token){
        mRepositoryActionInteractor.unstarRepo(owner, repo, token, this, new DefaultInteractorCallback<NetworkResponse>(mUi) {
            @Override
            public void onSuccess(NetworkResponse response) {
                mUi.showProgressBarLoading(false);
                mUi.unstarSuccess();
            }

            @Override
            public void onLoading() {
                mUi.showProgressBarLoading(true);
            }

            @Override
            public void onError(int msgId) {
                mUi.showProgressBarLoading(false);
                mUi.showError(msgId);
            }
        });
    }

    public void forkRepo(String owner, String repo, String token){
        mRepositoryActionInteractor.forkRepo(owner, repo, token, this, new DefaultInteractorCallback<NetworkResponse>(mUi) {
            @Override
            public void onSuccess(NetworkResponse response) {
                mUi.showProgressBarLoading(false);
                mUi.forkSuccess();
            }

            @Override
            public void onLoading() {
                mUi.showProgressBarLoading(true);
            }

            @Override
            public void onError(int msgId) {
                mUi.showProgressBarLoading(false);
                mUi.showError(msgId);
            }
        });
    }

}
