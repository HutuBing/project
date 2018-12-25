package com.ljb.sbdemo.models.enums;

public enum OrderStatusEnum {

    NO_FINISH(0, "未完成"),
    FINISH(1, "已完成");

    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code, String msg){
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
