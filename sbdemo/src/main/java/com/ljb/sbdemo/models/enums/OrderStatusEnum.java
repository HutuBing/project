package com.ljb.sbdemo.models.enums;

import java.util.Objects;

public enum OrderStatusEnum {

    NO_FINISH(0, "未完成"),
    FINISH(1, "已完成");

    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public static OrderStatusEnum getValue(Integer code) {
        if (Objects.nonNull(code)) {
            for (OrderStatusEnum value : OrderStatusEnum.values()) {
                if (value.code == code) {
                    return value;
                }
            }
        }
        return null;
    }

    public Integer getCode(){
        return this.code;
    }

    public String getMsg(){
        return this.msg;
    }
}
