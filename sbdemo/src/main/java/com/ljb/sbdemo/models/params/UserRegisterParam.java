package com.ljb.sbdemo.models.params;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "用户注册入参")
public class UserRegisterParam {

    @ApiModelProperty(value = "帐号", required = true, dataType = "String")
    private String account;
    @ApiModelProperty(value = "密码MD5加密串", required = true, dataType = "String")
    private String password;
    @ApiModelProperty(value = "用户名", required = true, dataType = "String")
    private String userName;
    @ApiModelProperty(value = "手机", dataType = "String")
    private String phone;
    @ApiModelProperty(value = "年龄", dataType = "String")
    private String age;
    @ApiModelProperty(value = "生日，例 2019-01-01", dataType = "String")
    private String birth;
    @ApiModelProperty(value = "性别 0：男 1：女", dataType = "String")
    private String sex;

}
