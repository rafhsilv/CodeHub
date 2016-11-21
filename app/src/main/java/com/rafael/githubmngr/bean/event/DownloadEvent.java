package com.rafael.githubmngr.bean.event;

import com.rafael.githubmngr.bean.Forkee;

/**
 * Created by Rafael on 2016/10/30.
 */
public class DownloadEvent extends BaseEvent{

    private Forkee forkee;

    public Forkee getForkee() {
        return forkee;
    }

    public void setForkee(Forkee forkee) {
        this.forkee = forkee;
    }
}
