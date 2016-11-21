package com.rafael.githubmngr.present;

import com.rafael.githubmngr.bean.FileTreeItem;
import com.rafael.githubmngr.bean.Tree;
import com.rafael.githubmngr.interactor.FileTreeInteractor;
import com.rafael.githubmngr.interactor.InteractorFactory;
import com.rafael.githubmngr.present.ui.ListUi;

/**
 *
 *
 * Created by Rafael on 2016/11/16.
 */
public class FileTreePresent extends ListPresent<ListUi<FileTreeItem>, FileTreeItem>{

    private FileTreeInteractor mFileTreeInteractor;

    public FileTreePresent(ListUi<FileTreeItem> ui) {
        super(ui);
        mFileTreeInteractor = InteractorFactory.newInteractorInstance(FileTreeInteractor.class);
    }

    public void loadFileTree(String name, String repo, String ref) {
        mFileTreeInteractor.loadFileTree(name, repo, ref, this, new DefaultInteractorCallback<Tree>(mUi) {
            @Override
            public void onError(int msgId) {
                defaultDealWithError(msgId, LoadType.FIRST);
            }

            @Override
            public void onSuccess(Tree tree) {
                defaultDealWithSuccess(tree.getTree(), LoadType.FIRST);
            }

            @Override
            public void onLoading() {
                defaultDealWithLoading(LoadType.FIRST);
            }
        });
    }

}
