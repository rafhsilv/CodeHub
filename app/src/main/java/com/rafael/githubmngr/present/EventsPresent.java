package com.rafael.githubmngr.present;

import com.rafael.githubmngr.bean.Page;
import com.rafael.githubmngr.bean.event.Event;
import com.rafael.githubmngr.interactor.EventsInteractor;
import com.rafael.githubmngr.interactor.InteractorFactory;
import com.rafael.githubmngr.present.ui.ListUi;

import java.util.List;

/**
 *
 *
 * Created by Rafael on 2016/11/16.
 */
public class EventsPresent extends ListPresent<ListUi<Event>, Event>{

    private EventsInteractor mEventsInteractor;

    public EventsPresent(ListUi<Event> ui) {
        super(ui);
        mEventsInteractor = InteractorFactory.newInteractorInstance(EventsInteractor.class);
    }

    public void getReceivedEvents(final LoadType loadType, String username, String token, Page page) {
        mEventsInteractor.getReceivedEvents(username, token, page, this, new DefaultInteractorCallback<List<Event>>(mUi) {
            @Override
            public void onError(int msgId) {
                defaultDealWithError(msgId, loadType);
            }

            @Override
            public void onSuccess(List<Event> eventWraps) {
                defaultDealWithSuccess(eventWraps, loadType);
            }

            @Override
            public void onLoading() {
                defaultDealWithLoading(loadType);
            }
        });
    }

}
