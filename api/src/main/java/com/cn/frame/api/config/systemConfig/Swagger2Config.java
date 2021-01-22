package com.cn.frame.api.config.systemConfig;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

/**
 * Create By SoFunTy
 * 2020/11/11 14:23
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Value("${swagger.baseUrl}")
    private String baseUrl;

//      接口分组
//    @Bean
//    public Docket createRestOpenApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .host(baseUrl)
//                .groupName("对外接口")
//                .enable(true)
//                .pathMapping("/")
//                .select()
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .apis(RequestHandlerSelectors.basePackage("com.cn.frame.api.controller"))
//                .paths(PathSelectors.ant("/open/**"))
//                .build()
//                .apiInfo(new ApiInfoBuilder()
//                        .title("sale api")
//                        .description("......")
//                        .version("1.0.0")
//                        .contact(new Contact("SoFunTy", "", "sofunty7@gamil.com"))
//                        .license("The Apache License")
//                        .licenseUrl("")
//                        .build())
//                ;
//    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host(baseUrl)
                .groupName("小程序插件接口")
                .enable(true)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.basePackage("com.cn.frame.api.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title("frame api")
                        .description("......")
                        .version("1.0.0")
                        .contact(new Contact("SoFunTy", "", "sofunty7@gamil.com"))
                        .license("The Apache License")
                        .licenseUrl("")
                        .build())
//                认证
                .globalOperationParameters(
                        Arrays.asList(new ParameterBuilder()
                                .name("Authorization")
                                .description("令牌")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(false)
                                .build())
                )
                ;
    }
}
