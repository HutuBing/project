package com.ljb.sbdemo.models.enums;

public enum DeleteFlagEunm {

    NO_DELETE(0, "未删除"),
    DELETE(1, "已删除");

    private Integer code;
    private String msg;

    DeleteFlagEunm(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode(){
        return this.code;
    }

    public String getMsg(){
        return this.msg;
    }

}
