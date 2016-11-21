package com.rafael.githubmngr.present;

import com.rafael.githubmngr.bean.Comment;
import com.rafael.githubmngr.interactor.CommentsInteractor;
import com.rafael.githubmngr.interactor.InteractorFactory;
import com.rafael.githubmngr.present.ui.ListUi;

import java.util.List;

/**
 *
 *
 * Created by Rafael on 2016/11/16.
 */
public class CommentsPresent extends ListPresent<ListUi<Comment>, Comment>{

    private CommentsInteractor mCommentsInteractor;

    public CommentsPresent(ListUi<Comment> ui) {
        super(ui);
        mCommentsInteractor = InteractorFactory.newInteractorInstance(CommentsInteractor.class);
    }

    public void getIssuesComments(String owner, String repo, String issueNumber) {
        mCommentsInteractor.getIssuesComments(owner, repo, issueNumber, this, new DefaultInteractorCallback<List<Comment>>(mUi) {
            @Override
            public void onError(int msgId) {
                defaultDealWithError(msgId, LoadType.FIRST);
            }

            @Override
            public void onSuccess(List<Comment> comments) {
                defaultDealWithSuccess(comments, LoadType.FIRST);
            }

            @Override
            public void onLoading() {
                defaultDealWithLoading(LoadType.FIRST);
            }
        });
    }

}
