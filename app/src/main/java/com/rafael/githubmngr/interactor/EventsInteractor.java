package com.rafael.githubmngr.interactor;

import com.rafael.githubmngr.bean.Page;
import com.rafael.githubmngr.bean.event.Event;

import java.util.List;

public interface EventsInteractor extends Interactor {

    public void getReceivedEvents(String username, String token, Page page, Object requestTag, InteractorCallBack<List<Event>> interactorCallBack);

}
