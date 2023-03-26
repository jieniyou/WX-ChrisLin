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
public class MvcConfig implements WebMvcConfigurer  {
    @Resource
    TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration patterns=registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")//指定拦截的url地址
                .excludePathPatterns("/user/**")
                .excludePathPatterns("/music/**")
               ;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods(new String[]{"GET","POST","PUT","DELETE"})
                .allowedHeaders("*")
                .exposedHeaders("*")
                .maxAge(3600);
    }
}
