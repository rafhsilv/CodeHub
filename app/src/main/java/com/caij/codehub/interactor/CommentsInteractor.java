package com.caij.codehub.interactor;

import com.caij.codehub.bean.Comment;

import java.util.List;

/**
 * /10/31.
 */
public interface CommentsInteractor extends Interactor {

    public void getIssuesComments(String owner, String repo, String issueNumber, Object requestTag, InteractorCallBack<List<Comment>> interactorCallBack);
}
