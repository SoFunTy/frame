package com.cn.frame.api.config.systemConfig;

import cn.hutool.core.util.ObjectUtil;
import com.cn.frame.api.common.CacheNameSpaceEnum;
import com.cn.frame.api.model.CacheMemberModel;
import com.cn.frame.api.service.CacheService;
import com.cn.frame.common.exception.FrServerException;
import com.cn.frame.common.result.ResultCode;
import com.github.pagehelper.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create By SoFunTy
 * 2020/11/16  14:40
 */
@Component
@Slf4j
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private CacheService cacheService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String bearerToken = request.getHeader("Authorization");

        if (StringUtil.isEmpty(bearerToken)) {
            throw new FrServerException(ResultCode.NOT_LOGIN);
        }

        CacheMemberModel memberModel = (CacheMemberModel) cacheService.getFromCache(CacheNameSpaceEnum.TOKEN_MEMBER_CACHE, bearerToken);

        if (ObjectUtil.isEmpty(memberModel)) {
            throw new FrServerException(ResultCode.NOT_FIND_TOKEN);
        }

        memberModel.setIp(getIpAddress(request));
        request.getSession().setAttribute("currentUser", memberModel);

        return true;
    }

    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (int index = 0; index < ips.length; index++) {
                String strIp = (String) ips[index];
                if (!("unknown".equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    break;
                }
            }
        }
        return ip;
    }
}
