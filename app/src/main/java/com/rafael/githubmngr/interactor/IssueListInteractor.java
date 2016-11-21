package com.rafael.githubmngr.interactor;

import com.rafael.githubmngr.bean.Issue;
import com.rafael.githubmngr.bean.Page;

import java.util.List;


public interface IssueListInteractor extends Interactor {

    void getIssueList(String owner, String repoName, Page page, Object requestTag, InteractorCallBack<List<Issue>> interactorCallBack);

}
