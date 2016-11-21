package com.rafael.githubmngr.present;

import com.rafael.githubmngr.bean.Comment;
import com.rafael.githubmngr.interactor.CommentActionInteractor;
import com.rafael.githubmngr.interactor.InteractorFactory;
import com.rafael.githubmngr.present.ui.CommentUi;

public class CommentPresent extends Present<CommentUi>{

    private CommentActionInteractor mCommentActionInteractor;

    public CommentPresent(CommentUi ui) {
        super(ui);
        mCommentActionInteractor = InteractorFactory.newInteractorInstance(CommentActionInteractor.class);
    }

    public void createCommentForIssue(String comment, String owner, String repo, String num, String token) {
        mCommentActionInteractor.createCommentForIssue(comment, owner, repo, num, token, this, new DefaultInteractorCallback<Comment>(mUi) {
            @Override
            public void onError(int msgId) {
                mUi.showProgressBarLoading(false);
                mUi.showError(msgId);
            }

            @Override
            public void onSuccess(Comment comment) {
                mUi.showProgressBarLoading(false);
                mUi.commentSuccess(comment);
            }

            @Override
            public void onLoading() {
                mUi.showProgressBarLoading(true);
            }
        });
    }

}
