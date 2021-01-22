package com.cn.frame.common.util;

import com.cn.frame.common.result.PageQuery;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;

/**
 * Create By SoFunTy
 * 2020/11/13  15:35
 */
public class PageUtil {

    public static void setPage(Object obj){
        PageQuery pageQuery = BeanConvertUtils.convert(obj, PageQuery.class);
        if (StringUtils.isNotBlank(pageQuery.getOrderType()) && StringUtils.isNotBlank(pageQuery.getOrderField())) {
            PageHelper.startPage(pageQuery.getCurrPage(), pageQuery.getPageSize(), pageQuery.getOrderby());
        } else {
            PageHelper.startPage(pageQuery.getCurrPage(), pageQuery.getPageSize());
        }
    }
}
