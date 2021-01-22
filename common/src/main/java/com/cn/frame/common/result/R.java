package com.cn.frame.common.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create By SoFunTy
 * 2020/11/04 15:36
 */
@Data
@NoArgsConstructor
@ApiModel(value = "返回结果对象")
public class R<T> {
    /**
     * 状态码
     */
    @ApiModelProperty(value = "请求状态码")
    private Integer code;

    /**
     * 返回消息
     */
    @ApiModelProperty(value = "请求信息")
    private String message;

    /**
     * 状态
     */
    @ApiModelProperty(value = "请求状态")
    private boolean status;

    /**
     * 返回数据
     */
    @ApiModelProperty(value = "请求结果")
    private T data;

    public R(Integer code, String message, boolean status, T data) {
        this.code = code;
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public R(IResultCode resultCode, boolean status, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.status = status;
        this.data = data;
    }

    public R(IResultCode resultCode, boolean status) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.status = status;
        this.data = null;
    }

    public static <T> R ok() {
        return new R<>(ResultCode.SUCCESS, true);
    }

//    public static <T> R ok(String message) {
//        return new R<>(ResultCode.SUCCESS.getCode(), message, true, null);
//    }

    public static <T> R ok(String data) {
        return new R<>(ResultCode.SUCCESS, true, data);
    }

    public static <T> R ok(T data) {
        return new R<>(ResultCode.SUCCESS, true, data);
    }

    public static <T> R fail() {
        return new R<>(ResultCode.ERROR, false);
    }

    public static <T> R fail(IResultCode resultCode) {
        return new R<>(resultCode, false);
    }

    public static <T> R fail(Integer code, String message) {
        return new R<>(code, message, false, null);
    }

    public static <T> R fail(IResultCode resultCode, T data) {
        return new R<>(resultCode, false, data);
    }

    public static <T> R fail(Integer code, String message, T data) {
        return new R<>(code, message, false, data);
    }

}
