/**
 * Author: 老洋
 * Date:  2021/6/1 14:12
 */
package com.yyy.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 用于：跳转自定义（error）异常页面
 */
@ControllerAdvice     //这个注解：Controller修饰的（都会进行）检查， 是否含有异常
public class ControllerExceptionHandler {
    //日志类
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)          //传入：异常
    public ModelAndView exceptionHandler(HttpServletRequest request, Exception e) throws Exception {
        logger.error("Request URL : {}, Exception : {}", request.getRequestURI(), e);

        //判断：当主页找不到， 交由spring原生处理
       if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
           throw e;


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url", request.getRequestURI()); //存放请求url
        modelAndView.addObject("exception", e);     //存放异常信息

        modelAndView.setViewName("error/error");        //设置：跳转（自定义错误页面）error, 会经过thymeleaf视图解析

        return modelAndView;
    }
}