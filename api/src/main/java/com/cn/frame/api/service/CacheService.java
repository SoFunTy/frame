package com.cn.frame.api.service;

import com.cn.frame.api.common.CacheNameSpaceEnum;

public interface CacheService {

    /**
     * TODO:取
     * @param spaceEnum
     * @param key
     * @return
     */
    Object getFromCache(CacheNameSpaceEnum spaceEnum, String key);

    /**
     * TODO:存
     * @param spaceEnum
     * @param key
     * @param value
     * @return
     */
    boolean putCache(CacheNameSpaceEnum spaceEnum, String key, Object value);

    /**
     * TODO:删
     * @param spaceEnum
     * @param key
     * @return
     */
    boolean evictFromCache(CacheNameSpaceEnum spaceEnum, String key);

}
