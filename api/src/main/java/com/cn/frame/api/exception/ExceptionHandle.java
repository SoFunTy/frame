package com.cn.frame.api.exception;

import com.cn.frame.common.exception.FrServerException;
import com.cn.frame.common.result.R;
import com.cn.frame.common.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 捕获异常的类，返回信息给浏览器，可以自定义返回的code,msg等信息
 * @Auther yechangliang
 * @Date 2020-10-15 14:29
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public R handle(Exception e) {
        if (e instanceof FrServerException) {   //判断异常是否是我们定义的异常
            FrServerException xmServerException = (FrServerException) e;
            return R.fail(xmServerException.getCode(), xmServerException.getMsg());
        }else {
            log.error("【系统异常】{}", e);
            return R.fail(ResultCode.ERROR.getCode(), "未知错误:"+e.getMessage());
        }
    }
}