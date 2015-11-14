package com.caij.codehub.request;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.caij.codehub.bean.event.Event;
import com.caij.codehub.bean.event.EventWrap;
import com.caij.lib.utils.GsonUtils;
import com.caij.lib.volley.request.GsonRequest;
import com.caij.lib.volley.request.JsonParseError;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Caij on 2015/10/30.
 */
public class EventRequest extends GsonRequest<List<EventWrap>>{
    public EventRequest(int method, String url,Response.Listener<List<EventWrap>> response, Response.ErrorListener listener) {
        super(method, url, null, response, listener);
    }

    public EventRequest(int method, String url, Map<String, String> params, Response.Listener<List<EventWrap>> response, Response.ErrorListener listener) {
        super(method, url, params, null, response, listener);
    }

    public EventRequest(int method, String url, Map<String, String> params, Map<String, String> head, Response.Listener<List<EventWrap>> response, Response.ErrorListener listener) {
        super(method, url, params, head, null, response, listener);
    }

    public EventRequest(int method, String url, Map<String, String> params, Map<String, String> head, String bodyContentType, Response.Listener<List<EventWrap>> response, Response.ErrorListener listener) {
        super(method, url, params, head, bodyContentType, null, response, listener);
    }

    public EventRequest(int method, String url, String body, Map<String, String> head, String bodyContentType, Response.Listener<List<EventWrap>> response, Response.ErrorListener listener) {
        super(method, url, body, head, bodyContentType, null, response, listener);
    }

    @Override
    protected Response<List<EventWrap>> parseNetworkResponse(NetworkResponse response) {
        List<Event> result;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(response.data);
        try {
            result = GsonUtils.getGson().fromJson(new InputStreamReader(byteArrayInputStream, HttpHeaderParser.parseCharset(response.headers)), new TypeToken<List< Event>>(){}.getType());
            List<EventWrap> eventWraps = convert(result);
            return Response.success(eventWraps, HttpHeaderParser.parseCacheHeaders(response));
        } catch (JsonSyntaxException e) {
            return Response.error(new JsonParseError());
        }catch (UnsupportedEncodingException e) {
            try {
                result = GsonUtils.getGson().fromJson(new InputStreamReader(byteArrayInputStream, Charset.forName("UTF-8")), mType);
                List<EventWrap> eventWraps = convert(result);
                return Response.success(eventWraps, HttpHeaderParser.parseCacheHeaders(response));
            }catch (JsonSyntaxException je) {
                return Response.error(new JsonParseError());
            }
        }
    }

    public List<EventWrap> convert(List<Event> events) {
        List<EventWrap> eventWraps = new ArrayList<>();
        if (events != null) {
            EventWrap eventWrap = null;
            for (Event event : events) {
                eventWrap = EventWrap.convert(event);
                eventWraps.add(eventWrap);
            }
        }
        return eventWraps;
    }
}
