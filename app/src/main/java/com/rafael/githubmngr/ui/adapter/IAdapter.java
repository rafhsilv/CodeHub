package com.rafael.githubmngr.ui.adapter;

import com.rafael.githubmngr.bean.Entity;

import java.util.List;

/**
 * Created by Rafael on 2016/9/23.
 */
public interface IAdapter<E extends Entity> {
    public void addEntity(E entity);
    public void removeEntity(E entiry);
    public void removeEntities(List<E> entities);
    public void addEntities(List<E> entities);
}
