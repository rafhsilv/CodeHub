package com.rafael.lib.utils;

import com.google.gson.Gson;

/**
 * Created by Rafael on 2016/8/24.
 */
public class GsonUtils {

    private static Gson gson = new Gson();

    public static Gson getGson() {
        return gson;
    }
}
