package com.best.projectB.utils;

public class Result<T> {



    public final static String SUCCESS = "success";
    public final static String ERROR = "error";


    private T data;

    private String message;





    public Result(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
