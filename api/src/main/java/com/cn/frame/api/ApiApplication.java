package com.cn.frame.api;

import com.yomahub.tlog.core.enhance.bytes.AspectLogEnhance;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cn.frame.api.mapper")
public class ApiApplication {

	static {
		AspectLogEnhance.enhance();}//进行日志增强，自动判断日志框架

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
