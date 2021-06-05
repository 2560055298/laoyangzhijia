/**
 * Author: 老洋
 * Date:  2021/6/1 20:01
 */
package com.yyy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 横切关注点：日志
 * 切面：LogAspect
 * 通知：前置、后置、后置返回
 * 切点：web包下的所有类（所有方法）
 */
@Aspect
@Component
public class LogAspect {
    //日志
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //切点
    @Pointcut("execution(* com.yyy.web.*.*(..))")
    public void log(){}

    //前置通知
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod =  joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);

        logger.info("Request：{}", requestLog);
    }

    //后置通知
    @After("log()")
    public void doAfter(){
        logger.info("--------doAfter------");
    }

    //后置通知返回
    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturn(Object result){
        logger.info("Result：{}", result);
    }


    /**
     * 请求 url
     * 访问者 ip
     * 调用方法 classMethod
     * 参数 args
     * 返回内容
     */
    private class RequestLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }


        @Override
        public String toString() {
            return "\n url: " + url + "\n ip：" + ip + "\n classMethod：" + classMethod + "\n args：" + args;
        }
    }
}