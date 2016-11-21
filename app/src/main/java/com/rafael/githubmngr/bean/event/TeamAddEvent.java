package com.rafael.githubmngr.bean.event;

import com.rafael.githubmngr.bean.Org;
import com.rafael.githubmngr.bean.Team;

/**
 * Created by Rafael on 2016/10/30.
 */
public class TeamAddEvent extends BaseEvent{
    private Team team;
    private Org organization;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Org getOrganization() {
        return organization;
    }

    public void setOrganization(Org organization) {
        this.organization = organization;
    }
}
