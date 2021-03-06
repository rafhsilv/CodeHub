package com.rafael.lib.utils;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * log  util
 */
public class LogUtil {

    public static boolean LOG_DEBUG = true;

    /**
     * It is used for json pretty print
     */
    private static final int JSON_INDENT = 4;

    public static void e(String tag, String msg) {
        if (LOG_DEBUG) {
            Log.e(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (LOG_DEBUG) {
            Log.i(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (LOG_DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void v(String tag, String msg) {
        if (LOG_DEBUG) {
            Log.v(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (LOG_DEBUG) {
            Log.w(tag, msg);
        }
    }

    public static void wtf(String tag, String msg) {
        if (LOG_DEBUG) {
            Log.wtf(tag, msg);
        }
    }

    public static void e(Object tag, String msg) {
        if (LOG_DEBUG) {
            Log.e(tag.getClass().getSimpleName(), msg);
        }
    }

    public static void i(Object tag, String msg) {
        if (LOG_DEBUG) {
            Log.i(tag.getClass().getSimpleName(), msg);
        }
    }

    public static void d(Object tag, String msg) {
        if (LOG_DEBUG) {
            Log.d(tag.getClass().getSimpleName(), msg);
        }
    }

    public static void v(Object tag, String msg) {
        if (LOG_DEBUG) {
            Log.v(tag.getClass().getSimpleName(), msg);
        }
    }

    public static void w(Object tag, String msg) {
        if (LOG_DEBUG) {
            Log.w(tag.getClass().getSimpleName(), msg);
        }
    }

    public static void wtf(Object tag, String msg) {
        if (LOG_DEBUG) {
            Log.wtf(tag.getClass().getSimpleName(), msg);
        }
    }

    public static void json(String tag, String msg) {
        if (LOG_DEBUG) {
            if (TextUtils.isEmpty(msg)) {
                Log.e(tag, "msg is null.");
                return;
            }
            try {
                if (msg.startsWith("{")) {
                    JSONObject jsonObject = new JSONObject(msg);
                    String message = jsonObject.toString(JSON_INDENT);
                    String[] lines = message.split(System.getProperty("line.separator"));
                    Log.d(tag, "┌───────────────────────────────────────────────────────────────────────────────────────");
                    for (String line : lines) {
                        Log.d(tag, "│" + " " + line);
                    }
                    Log.d(tag, "└───────────────────────────────────────────────────────────────────────────────────────");
                    return;
                }
                if (msg.startsWith("[")) {
                    JSONArray jsonArray = new JSONArray(msg);
                    String message = jsonArray.toString(JSON_INDENT);
                    String[] lines = message.split(System.getProperty("line.separator"));
                    Log.d(tag, "┌───────────────────────────────────────────────────────────────────────────────────────");
                    for (String line : lines) {
                        Log.d(tag, "│" + " " + line);
                    }
                    Log.d(tag, "└───────────────────────────────────────────────────────────────────────────────────────");
                }
            } catch (JSONException e) {
                Log.e(tag, e.getCause().getMessage() + "\n" + msg);
            }
        }
    }

}
