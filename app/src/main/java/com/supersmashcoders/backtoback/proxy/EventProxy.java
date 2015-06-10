package com.supersmashcoders.backtoback.proxy;

import android.content.Context;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.supersmashcoders.backtoback.models.EventModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EventProxy {
    public void getEvents(final Context context, final RequestListener<List<EventModel>> listener) {
        final String url = "http://jsonplaceholder.typicode.com/posts";

        // Request a string response from the provided URL.
        JsonArrayRequest eventsRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<EventModel> eventModelList = new ArrayList<>(response.length());
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        eventModelList.add(EventModel.of(jsonObject));
                    } catch(JSONException e) {
                        Log.e("JSON PARSE", "Failed to get JSON at position " + i + " from JSON Array " + response.toString());
                    }
                }
                listener.onComplete(eventModelList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("API FAIL", "Error calling API " + url);
                listener.onError();
            }
        });

        // Add the request to the RequestQueue.
        ApplicationRequestQueue.INSTANCE.addToRequestQueue(context, eventsRequest);
    }

    public void getEvent(final Context context, long id, final RequestListener<EventModel> listener) {
        final String url = "http://jsonplaceholder.typicode.com/posts/" + id;

        // Request a string response from the provided URL.
        JsonObjectRequest eventRequest = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                EventModel eventModel = EventModel.of(response);
                listener.onComplete(eventModel);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError();
                Log.e("API FAIL", "Error calling API " + url);
            }
        });

        // Add the request to the RequestQueue.
        ApplicationRequestQueue.INSTANCE.addToRequestQueue(context, eventRequest);
    }
}
