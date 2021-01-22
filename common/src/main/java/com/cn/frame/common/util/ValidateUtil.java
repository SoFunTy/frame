package com.cn.frame.common.util;

import cn.hutool.core.util.ObjectUtil;
import com.cn.frame.common.exception.FrServerException;
import lombok.extern.slf4j.Slf4j;

/**
 * Create By SoFunTy
 * 2020/11/13  17:09
 */
@Slf4j
public class ValidateUtil {

    /**
     * TODO:参数非空校验
     * @param param
     * @param obj
     */
    public static void isNotNull(String param,Object obj){
        if (ObjectUtil.isEmpty(obj)){
            log.error("{}为空",obj);
            throw new FrServerException(param + "禁止为空");
        }
    }
    /**
     * TODO:参数非空校验
     * @param param
     * @param obj
     */
    public static void isNotNullWithMsg(String param,Object obj){
        if (ObjectUtil.isEmpty(obj)){
            log.error("{}{}",param,obj);
            throw new FrServerException(param);
        }
    }


}
