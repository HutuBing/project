package com.ljb.sbdemo.models.result;

public class Result<T> {

    private Integer code;

    private String msg;

    private T data;

    public static  <T> Result<T> success(T data){
        return new Result<T>(data);
    }

    public static <T> Result<T> error(Integer code, String msg){
        return new Result<T>(code, msg);
    }

    private Result(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    private Result(T data){
        this.code=000000;//默认000000是成功
        this.msg="SUCCESS";
        this.data = data;
    }
}
