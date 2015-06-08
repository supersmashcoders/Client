package com.supersmashcoders.backtoback.proxy;

public interface RequestListener<T> {
    void onComplete(T object);
    void onError();
}
