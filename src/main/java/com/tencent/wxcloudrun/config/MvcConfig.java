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

    /**
     * 拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration patterns=registry.addInterceptor(tokenInterceptor);
        patterns.excludePathPatterns("/*","/static/**","/user/**","/music/**")
                .addPathPatterns("/**");
    }

    /**
     * 跨域配置
     * @param registry
     */
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
