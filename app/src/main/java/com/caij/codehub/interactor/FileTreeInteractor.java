package com.caij.codehub.interactor;

import com.caij.codehub.bean.Tree;

/**
 * /11/2.
 */
public interface FileTreeInteractor extends Interactor {

    public void loadFileTree(String name, String repo, String ref, Object requestTag, InteractorCallBack<Tree> interactorCallBack);

}
