package com.rafael.githubmngr.interactor;

import com.rafael.githubmngr.bean.Tree;

/**
 * /11/2.
 */
public interface FileTreeInteractor extends Interactor {

    public void loadFileTree(String name, String repo, String ref, Object requestTag, InteractorCallBack<Tree> interactorCallBack);

}
