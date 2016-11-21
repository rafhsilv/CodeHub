package com.rafael.githubmngr.present.ui;

import com.rafael.githubmngr.bean.Repository;

/**
 *
 *
 * Created by Rafael on 2016/11/16.
 */
public interface RepositoryInfoUi extends BaseUi{

    public void getRepositoryInfoSuccess(Repository repository);

    public void getStarStateSuccess(boolean isStar);

    public void starSuccess();

    public void unstarSuccess();

    public void forkSuccess();

}
