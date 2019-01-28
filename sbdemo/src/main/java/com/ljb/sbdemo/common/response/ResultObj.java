package com.ljb.sbdemo.common.response;

public class ResultObj<T> {
    public static final int CODE_OK = 2000;
    public static final int CODE_NOT_PASS = 3000;
    public static final int CODE_NOT_ALLOW = 3425;
    public static final int CODE_PARAM_ERR = 3406;
    public static final int CODE_SERVER_ERR = 4000;
    public static final int CODE_TOKEN_INVALID = 3426;
    private int code = 2000;
    private String msg = "OK";
    private T data = null;
    private boolean success = true;

    public ResultObj() {
    }

    public ResultObj(T data) {
        this.data = data;
    }

    public ResultObj(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultObj(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultObj(int code, String msg, T data, boolean success) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResultObj<T> success(T data) {
        return new ResultObj(data);
    }

    public static <T> ResultObj<T> notPass() {
        return new ResultObj(3000, "权限不足，无法操作该资源", (Object)null);
    }

    public static <T> ResultObj<T> notPass(String msg) {
        return new ResultObj(3000, msg, (Object)null);
    }

    public static <T> ResultObj<T> notAllow() {
        return new ResultObj(3425, "未经许可的用户", (Object)null);
    }

    public static <T> ResultObj<T> notAllow(String msg) {
        return new ResultObj(3425, msg, (Object)null);
    }

    public static <T> ResultObj<T> parameterError() {
        return new ResultObj(3406, "参数解析错误", (Object)null);
    }

    public static <T> ResultObj<T> parameterError(String msg) {
        return new ResultObj(3406, msg, (Object)null);
    }

    public static <T> ResultObj<T> serverError() {
        return new ResultObj(4000, "服务器异常", (Object)null);
    }

    public static <T> ResultObj<T> serverError(String msg) {
        return new ResultObj(4000, msg, (Object)null);
    }

    public static <T> ResultObj<T> newResult(int code, String msg, T data) {
        return new ResultObj(code, msg, data);
    }

    public static <T> ResultObj<T> newResult(int code, String msg) {
        return new ResultObj(code, msg);
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
