package com.cn.frame.api.service.impl;

import com.cn.frame.api.common.CacheNameSpaceEnum;
import com.cn.frame.api.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Create By SoFunTy
 * 2020/11/16  14:34
 */
@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private CacheManager cacheManager;

    /**
     * 获取缓存内容
     * @param spaceEnum
     * @param key
     * @return
     */
    @Override
    public Object getFromCache(CacheNameSpaceEnum spaceEnum, String key) {
        final Cache.ValueWrapper valueWrapper = cacheManager.getCache(spaceEnum.getSpaceName()).get(key);
        return null == valueWrapper ? null : valueWrapper.get();
    }

    /**
     * 设置缓存数据
     * @param spaceEnum
     * @param key
     * @param value
     * @return
     */
    @Override
    public boolean putCache(CacheNameSpaceEnum spaceEnum, String key, Object value) {
        if (null == value) {
            return false;
        }
        cacheManager.getCache(spaceEnum.getSpaceName()).put(key, value);

        return true;
    }

    /**
     * 删除缓存数据
     * @param spaceEnum
     * @param key
     * @return
     */
    @Override
    public boolean evictFromCache(CacheNameSpaceEnum spaceEnum, String key) {
        if(null == key){
            return false;
        }
        cacheManager.getCache(spaceEnum.getSpaceName()).evict(key);

        return true;
    }

}
