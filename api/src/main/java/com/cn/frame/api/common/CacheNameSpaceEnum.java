package com.cn.frame.api.common;

import java.util.Arrays;

/**
 * Create By SoFunTy
 * 2020/11/18  16:34
 */
public enum  CacheNameSpaceEnum {

    MEMBERID_TOKEN_CACHE("用户id::token","MEMBERID_TOKEN_CACHE"),
    TOKEN_MEMBER_CACHE("token::用户","TOKEN_MEMBER_CACHE")
    ;

    private String name;

    private String spaceName;

    CacheNameSpaceEnum(String name, String spaceName) {
        this.name = name;
        this.spaceName = spaceName;
    }

    public String getName() {
        return name;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public static String getSpaceName(String name) {
        return Arrays.asList(values()).stream().filter(m -> m.getName() == name).findFirst().get().getSpaceName();
    }
}
