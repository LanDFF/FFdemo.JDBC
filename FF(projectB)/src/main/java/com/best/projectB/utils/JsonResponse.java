package com.best.projectB.utils;

import java.util.function.Supplier;

public class JsonResponse<T> {

    private T data;

    private int code;

    private String message;

    public JsonResponse<T> OK(Supplier<T> supplier) {
        data = supplier.get();
        return new JsonResponse<>(data);
    }

    public static <T> JsonResponse create(T data) {
        return new JsonResponse(data);
    }

    public JsonResponse() {
    }

    public JsonResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
