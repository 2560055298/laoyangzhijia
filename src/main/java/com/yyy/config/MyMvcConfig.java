/**
 * Author: 老洋
 * Date:  2021/7/3 16:25
 */
package com.yyy.config;


import com.yyy.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    /**
     * 注入：自定义配置（拦截器)
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/index", "/front/**", "/after/login", "/common/**", "/error/**")
                .excludePathPatterns("/css/**", "/js/**", "/images/**", "/fonts/**", "/lib/**");
    }

    /**
     * 开启跨域：当一个请求url的协议、域名、端口三者之间任意一个与当前页面url不同即为跨域
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路由
        registry.addMapping("/**")
                // 设置允许跨域请求的域名
                .allowedOriginPatterns("*")    // 注意此处
                // 是否允许证书（cookies）
                .allowCredentials(true)
                // 设置允许的方法
                .allowedMethods("*")
                // 跨域允许时间
                .maxAge(3600);
    }
}