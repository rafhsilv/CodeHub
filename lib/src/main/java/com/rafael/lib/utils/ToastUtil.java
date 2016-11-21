package com.rafael.lib.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Rafael on 2016/8/25.
 */
public class ToastUtil {

    private static Toast mToast ;

    public static void show(Context context, String msg) {
        if (mToast ==  null) {
            synchronized (ToastUtil.class) {
                if (mToast ==  null) {
                    mToast = Toast.makeText(context.getApplicationContext(), msg, Toast.LENGTH_SHORT);
                }else {
                    mToast.setText(msg);
                }
            }
        }else {
            mToast.setText(msg);
        }
        mToast.show();
    }

    public static void show(Context context, int id) {
        show(context, context.getString(id));
    }
}
