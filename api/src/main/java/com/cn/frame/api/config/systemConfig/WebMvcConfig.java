package com.cn.frame.api.config.systemConfig;

import com.cn.frame.api.annotation.CurrentUserHandlerMethodArgReslover;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create By SoFunTy
 * 2020/11/16  14:55
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    private AuthorizationInterceptor authorizationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        String excludePathStr = "/swagger-resources/**,/v2/**,/swagger-ui.html/**,/webjars/**" +
                ",/member/loginByMobile,/member/easyLogin";
        String[] excludePathArr = excludePathStr.split(",");
        registry.addInterceptor(authorizationInterceptor)
                .excludePathPatterns(excludePathArr)
                .addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new CurrentUserHandlerMethodArgReslover());
    }
}
