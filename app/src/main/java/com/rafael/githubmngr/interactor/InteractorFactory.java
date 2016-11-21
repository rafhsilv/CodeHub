package com.rafael.githubmngr.interactor;

import com.rafael.githubmngr.interactor.imp.AuthenticationInteractorImp;
import com.rafael.githubmngr.interactor.imp.CommentActionInteractorImp;
import com.rafael.githubmngr.interactor.imp.CommentsInteractorImp;
import com.rafael.githubmngr.interactor.imp.EventsInteractorImp;
import com.rafael.githubmngr.interactor.imp.FileTreeInteractorImp;
import com.rafael.githubmngr.interactor.imp.FollowActionInteractorImp;
import com.rafael.githubmngr.interactor.imp.IssueInteractorImp;
import com.rafael.githubmngr.interactor.imp.IssueListInteractorImp;
import com.rafael.githubmngr.interactor.imp.RepositoryActionInteractorImp;
import com.rafael.githubmngr.interactor.imp.RepositoryInfoInteractorImp;
import com.rafael.githubmngr.interactor.imp.RepositoryListInteractorImp;
import com.rafael.githubmngr.interactor.imp.UserInteractorImp;
import com.rafael.githubmngr.interactor.imp.UserListInteractorImp;

import java.util.HashMap;
import java.util.Map;

/**
 * /10/31.
 */
public class InteractorFactory {

    private static Map<Class, Class> pclazzs = new HashMap<>();

    static {
        pclazzs.put(AuthenticationInteractor.class, AuthenticationInteractorImp.class);
        pclazzs.put(EventsInteractor.class, EventsInteractorImp.class);
        pclazzs.put(RepositoryInfoInteractor.class, RepositoryInfoInteractorImp.class);
        pclazzs.put(RepositoryListInteractor.class, RepositoryListInteractorImp.class);
        pclazzs.put(UserListInteractor.class, UserListInteractorImp.class);
        pclazzs.put(UserInteractor.class, UserInteractorImp.class);
        pclazzs.put(IssueInteractor.class, IssueInteractorImp.class);
        pclazzs.put(CommentsInteractor.class, CommentsInteractorImp.class);
        pclazzs.put(RepositoryActionInteractor.class, RepositoryActionInteractorImp.class);
        pclazzs.put(FollowActionInteractor.class, FollowActionInteractorImp.class);
        pclazzs.put(FileTreeInteractor.class, FileTreeInteractorImp.class);
        pclazzs.put(IssueListInteractor.class, IssueListInteractorImp.class);
        pclazzs.put(CommentActionInteractor.class, CommentActionInteractorImp.class);
    }

    public static <P extends Interactor> P newInteractorInstance(Class<P> iClass) {
        Class<P> tClass = pclazzs.get(iClass);
        if (tClass != null) {
            try {
                return  tClass.newInstance();
            } catch (Exception e) {
                throw new IllegalStateException(e.getMessage());
            }
        }else {
            throw new IllegalStateException("unregist Interactor");
        }
    }

}
