/**
 * Author: 老洋
 * Date:  2021/6/5 20:47
 */
package com.yyy.config;


import com.yyy.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")       //拦截：后台所有页面
                .excludePathPatterns("/admin")      //排除：默认跳转登录页面
                .excludePathPatterns("/admin/login")  //排除：登录页面
                .excludePathPatterns("/css/**", "/js/**", "/images/**");
    }
}