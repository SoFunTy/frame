package com.cn.frame.common.result;

/**
 * Create By SoFunTy
 * 2020/11/04 15:36
 */
public interface IResultCode {
    /**
     * 获取状态码
     *
     * @return 状态码
     */
    Integer getCode();

    /**
     * 获取返回消息
     *
     * @return 返回消息
     */
    String getMessage();
}
