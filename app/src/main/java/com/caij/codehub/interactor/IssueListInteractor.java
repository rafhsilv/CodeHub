package com.caij.codehub.interactor;

import com.caij.codehub.bean.Issue;
import com.caij.codehub.bean.Page;

import java.util.List;


public interface IssueListInteractor extends Interactor {

    void getIssueList(String owner, String repoName, Page page, Object requestTag, InteractorCallBack<List<Issue>> interactorCallBack);

}
