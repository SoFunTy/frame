package com.cn.frame.api.annotation;

import com.cn.frame.api.model.CacheMemberModel;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义
 * Create By SoFunTy
 * 2020/11/16  15:36
 */
public class CurrentUserHandlerMethodArgReslover implements HandlerMethodArgumentResolver {

    /**
     * 注解可用判断
     * @param parameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(CurrentUser.class) != null && parameter.getParameterType() == CacheMemberModel.class;
    }

    /**
     * 参数注入
     * @param parameter
     * @param mavContainer
     * @param webRequest
     * @param binderFactory
     * @return
     * @throws Exception
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        //取得HttpServletRequest
        HttpServletRequest request= (HttpServletRequest) webRequest.getNativeRequest();
        //取出session中的User
        return (CacheMemberModel)request.getSession().getAttribute("currentUser");
    }
}
