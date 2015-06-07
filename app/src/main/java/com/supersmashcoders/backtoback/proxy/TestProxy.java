package com.supersmashcoders.backtoback.proxy;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class TestProxy {

    public void getFrontPage(Context context) {
        String url = "http://www.google.com";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("TEST", "Response is: " + response.substring(0, 500));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("TEST", "Error");
                    }
                }
        );

        // Add the request to the RequestQueue.
        ApplicationRequestQueue.INSTANCE.addToRequestQueue(context, stringRequest);
    }
}
