package com.rafael.githubmngr.utils;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Rafael on 2016/9/19.
 */
public class TextTypeFaceUtils {

    private static Typeface mTypeface;

    public static Typeface getGithubTypeFace(Context context) {
        if (mTypeface == null) {
            mTypeface = Typeface.createFromAsset(context.getAssets(), "octicons.ttf");
        }
        return mTypeface;
    }
}
