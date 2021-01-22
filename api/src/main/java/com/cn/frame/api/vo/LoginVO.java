package com.cn.frame.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Create By SoFunTy
 * 2020/11/27  12:30
 */
@Data
@ApiModel(value = "登录对象")
public class LoginVO implements Serializable {


    @ApiModelProperty(value = "token")
    private String token;

    @ApiModelProperty(value = "openId")
    private String openId;

    @ApiModelProperty(value = "商城id")
    private Integer mallId;

}
