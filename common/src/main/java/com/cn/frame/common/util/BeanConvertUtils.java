package com.cn.frame.common.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

import java.util.ArrayList;
import java.util.List;

/**
 * Create By SoFunTy
 * 2020/10/12 11:41
 */
public class BeanConvertUtils {

    /**
     * 单体拷贝
     * @param source
     * @param targetClass
     * @param <K>
     * @param <T>
     * @return
     */
    public static <K, T> K convert(T source, Class<K> targetClass) {
        K target = null;

        if (source != null) {
            try {
                // 初始化bean
                target = targetClass.newInstance();

                // 简单的直接拷贝
                BeanUtils.copyProperties(source, target);

            } catch (BeansException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return target;
    }

    /**
     * 列表拷贝
     * @param sources
     * @param targetClass
     * @param <K>
     * @param <T>
     * @return
     */
    public static <K, T> List<K> convertList(List<T> sources, Class<K> targetClass) {
        List<K> targets = null;

        if (sources != null) {
            targets = new ArrayList<>(sources.size());

            // 循环转换
            K target;
            for (T source : sources) {
                target = convert(source, targetClass);
                if (target != null) {
                    targets.add(target);
                }
            }
        }

        return targets;
    }

}
