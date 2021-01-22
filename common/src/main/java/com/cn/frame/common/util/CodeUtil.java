package com.cn.frame.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 流水单号生产
 * Create By SoFunTy
 * 2020/8/8 18:43
 */
public class CodeUtil {

    /**
     * 订单流水号
     * @return
     */
    public static String getCode() {
        Date date=new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        String time = format.format(date);
        return time+ IdWorkerUtil.getStringId(6);
    }

}
