package com.rafael.githubmngr.present;

import com.rafael.githubmngr.bean.Issue;
import com.rafael.githubmngr.bean.Page;
import com.rafael.githubmngr.interactor.InteractorFactory;
import com.rafael.githubmngr.interactor.IssueListInteractor;
import com.rafael.githubmngr.present.ui.ListUi;

import java.util.List;

/**
 *
 *
 * Created by Rafael on 2016/11/16.
 */
public class RepoIssuesPresent extends ListPresent<ListUi<Issue>, Issue>{

    private IssueListInteractor mIssueListInteractor;

    public RepoIssuesPresent(ListUi<Issue> ui) {
        super(ui);
        mIssueListInteractor = InteractorFactory.newInteractorInstance(IssueListInteractor.class);
    }

    public void getIssueList(final LoadType loadType, String owner, String repoName, Page page) {
        mIssueListInteractor.getIssueList(owner, repoName, page, this, new DefaultInteractorCallback<List<Issue>>(mUi) {
            @Override
            public void onError(int msgId) {
                defaultDealWithError(msgId, loadType);
            }

            @Override
            public void onSuccess(List<Issue> issues) {
                defaultDealWithSuccess(issues, loadType);
            }

            @Override
            public void onLoading() {
                defaultDealWithLoading(loadType);
            }
        });
    }
}
