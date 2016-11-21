package com.rafael.githubmngr.present;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.rafael.githubmngr.R;
import com.rafael.githubmngr.interactor.InteractorCallBack;
import com.rafael.githubmngr.present.ui.BaseUi;
import com.rafael.lib.utils.VolleyManager;
import com.rafael.lib.volley.request.JsonParseError;

/**
 * Created by Rafael on 2016/11/16.
 */
public abstract class DefaultInteractorCallback<E> implements InteractorCallBack<E> {

    private BaseUi mUi;

    public DefaultInteractorCallback(BaseUi ui) {
        this.mUi = ui;
    }

    @Override
    public void onError(VolleyError error) {
        onError(dealWithVolleyError(error));
    }

    private int dealWithVolleyError(VolleyError error) {
        int msgId;
        if (error instanceof ServerError || error instanceof JsonParseError) {
            msgId = R.string.server_error_hint;
        }else if(error instanceof NetworkError || error instanceof TimeoutError) {
            msgId = R.string.network_error_hint;
        }else if (error instanceof AuthFailureError) {
            msgId = R.string.account_error_hint;
            VolleyManager.cancelAllRequest();
            mUi.onAuthError();
        }else {
            msgId = R.string.data_load_error_hint;
        }
        return msgId;
    }

    public abstract void onError(int msgId);
}
