package com.rafael.githubmngr.interactor;

import com.rafael.githubmngr.bean.Comment;

import java.util.List;

/**
 * /10/31.
 */
public interface CommentsInteractor extends Interactor {

    public void getIssuesComments(String owner, String repo, String issueNumber, Object requestTag, InteractorCallBack<List<Comment>> interactorCallBack);
}
