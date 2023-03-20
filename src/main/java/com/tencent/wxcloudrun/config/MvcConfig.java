package com.tencent.wxcloudrun.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

/**
 * @Author: 解你忧
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: WX-ChrisLin
 * @Date_Time: 2023/3/20 20:55
 */
@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {
    @Resource
    TokenInterceptor tokenInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration patterns=registry.addInterceptor(tokenInterceptor)
                .excludePathPatterns("/user/**")
                .addPathPatterns("/**")//指定拦截的url地址
               ;
    }
}
