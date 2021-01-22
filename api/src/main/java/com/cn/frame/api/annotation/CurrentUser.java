package com.cn.frame.api.annotation;

import java.lang.annotation.*;

/**
 * TODO：当前用户
 * 修饰范围：方法函数
 * 保留时间：运行时保留
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {
}
