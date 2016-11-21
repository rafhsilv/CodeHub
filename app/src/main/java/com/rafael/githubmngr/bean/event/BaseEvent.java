package com.rafael.githubmngr.bean.event;

import com.rafael.githubmngr.bean.Entity;
import com.rafael.githubmngr.bean.Repository;
import com.rafael.githubmngr.bean.User;

/**
 * Created by Rafael on 2016/10/30.
 */
public class BaseEvent extends Entity{

    private User sender;
    private Repository repository;

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }
}
