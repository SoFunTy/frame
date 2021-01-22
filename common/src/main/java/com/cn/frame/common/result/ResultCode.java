package com.cn.frame.common.result;

import lombok.Getter;

/**
 * Create By SoFunTy
 * 2020/11/04 15:36
 */
@Getter
public enum ResultCode implements IResultCode {

    SUCCESS(0, "成功"),
    FAIL(-1,"失败"),
    INVALID_ACCOUNT(1000,"账号或密码错误"),
    NOT_LOGIN(1002, "用户未登陆"),

    /** 签名失败 **/
    SIGN_INVALID(10001, "签名失败"),
    /** 参数缺失 **/
    REQUIRED_PARAMS_IS_MISSING(10002, "参数缺失"),
    /** 系统异常 **/
    ERROR(10003, "好像出了一点小问题"),
    /** 参数异常 **/
    REQUIRED_PARAMS_ERROR(10004, "参数异常"),
    /** 账号/密码错误，或该用户不存在 **/
    INVALID_USER(10005, "账号/密码错误，或该用户不存在"),
    /** 权限不足 **/
    NOT_PERMISSIONS(10006, "权限不足"),
    /** token不存在或已过期 **/
    NOT_FIND_TOKEN(10007, "未登录或登录过期");
    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
