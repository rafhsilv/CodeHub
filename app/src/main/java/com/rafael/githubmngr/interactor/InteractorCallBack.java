package com.rafael.githubmngr.interactor;

import com.android.volley.VolleyError;

/**
 * /11/4.
 */
public interface InteractorCallBack<E> {

    public void onSuccess(E e);

    public void onLoading();

    public void onError(VolleyError error);

}
