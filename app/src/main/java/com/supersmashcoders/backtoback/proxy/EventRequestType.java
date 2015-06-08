package com.supersmashcoders.backtoback.proxy;

import com.supersmashcoders.backtoback.R;

public enum EventRequestType {
    MY_SUBSCRIBED_EVENTS ("Subscribed", R.string.title_my_subscribed_events),
    MY_CREATED_EVENTS ("Created", R.string.title_my_created_events);

    private String requestName;
    private int titleResourceId;

    EventRequestType(String requestName, int titleResourceId) {
        this.requestName = requestName;
        this.titleResourceId = titleResourceId;
    }

    public String getRequestName() {
        return requestName;
    }

    public int getTitleResourceId() {
        return titleResourceId;
    }
}
