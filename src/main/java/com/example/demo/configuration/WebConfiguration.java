package com.example.demo.configuration;

import com.example.demo.interceptor.AdminInterceptor;
import com.example.demo.interceptor.Interceptor;
import com.example.demo.interceptor.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    UserInterceptor userInterceptor;

    @Autowired
    AdminInterceptor adminInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry
                .addInterceptor(userInterceptor)
                .addPathPatterns("/user/id")
                .addPathPatterns("/store");

        registry
                .addInterceptor(adminInterceptor)
                .addPathPatterns("/user/all");
    }

}
