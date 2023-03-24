package com.tencent.wxcloudrun.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: 解你忧
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: WX-ChrisLin
 * @Date_Time: 2023/3/20 20:55
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Resource
    TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration patterns=registry.addInterceptor(tokenInterceptor)
                .excludePathPatterns("/user/**")
                .excludePathPatterns("/music/**")
                .addPathPatterns("/**")//指定拦截的url地址
               ;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("token")
                .maxAge(3600);
    }
}
