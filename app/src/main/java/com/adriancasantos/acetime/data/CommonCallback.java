package com.adriancasantos.acetime.data;

public interface CommonCallback<T> {
    void onSuccess(T data);
    void onError(Throwable error);
}
