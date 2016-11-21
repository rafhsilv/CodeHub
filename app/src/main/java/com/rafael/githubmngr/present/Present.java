package com.rafael.githubmngr.present;

import com.rafael.githubmngr.present.ui.BaseUi;
import com.rafael.lib.utils.VolleyManager;

/**
 * Created by Rafael on 2016/11/16.
 */
public abstract class Present<UI extends BaseUi> {

    public UI mUi;

    public Present(UI ui) {
        this.mUi = ui;
        if (ui == null) throw new RuntimeException("ui is null");
    }

    public void onDeath() {
        VolleyManager.cancelRequestByTag(this);
        mUi = null;
    }

}
