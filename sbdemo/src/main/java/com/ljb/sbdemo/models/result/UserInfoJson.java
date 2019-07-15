package com.ljb.sbdemo.models.result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "用户信息")
public class UserInfoJson {

    @ApiModelProperty(value = "用户id", required = true, dataType = "String")
    private String id;
    @ApiModelProperty(value = "帐号", required = true, dataType = "String")
    private String account;
    @ApiModelProperty(value = "年龄", required = true, dataType = "String")
    private String age;
    @ApiModelProperty(value = "生日", required = true, dataType = "String")
    private String birth;
    @ApiModelProperty(value = "用户名", required = true, dataType = "String")
    private String name;
    @ApiModelProperty(value = "相似度", required = true, dataType = "String")
    private String similarity;

}
