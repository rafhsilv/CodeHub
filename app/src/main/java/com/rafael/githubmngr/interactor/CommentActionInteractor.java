package com.rafael.githubmngr.interactor;

import com.rafael.githubmngr.bean.Comment;

/**
 * /11/3.
 */
public interface CommentActionInteractor extends Interactor {

    public void createCommentForIssue(String comment, String owner, String repo, String num, String token, Object requestTag, InteractorCallBack<Comment> interactorCallBack);

}
