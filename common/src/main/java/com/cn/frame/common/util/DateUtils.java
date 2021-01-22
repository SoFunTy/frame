package com.cn.frame.common.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Create By SoFunTy
 * 2020/10/20 12:01
 */
public class DateUtils {




    /**
     * TODO:获取目标时区当前LocalDateTime
     * @param zoneId
     * @return
     */
    public static LocalDateTime getNowLocalDateTime(ZoneId zoneId){
        return LocalDateTime.now(zoneId);
    }

    /**
     * TODO:获取目标时区当前LocalDate
     * @param zoneId
     * @return
     */
    public static LocalDate getNowLocalDate(ZoneId zoneId){
        return LocalDate.now(zoneId);
    }

    /**
     * TODO:字符串转LocalDateTime
     * @param date
     * @return
     */
    public static LocalDateTime getLocalDateTime(String date){
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(date, dtf2);
    }

    /**
     * TODO:字符串转LocalDate
     * @param date
     * @return
     */
    public static LocalDate getLocalDate(String date){
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, dtf2);
    }


}
