/**
 * Author: 老洋
 * Date:  2021/6/5 20:43
 */
package com.yyy.interceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        if(request.getSession().getAttribute("user") == null){
            request.getSession().setAttribute("message", "没有权限, 请登录。");
            response.sendRedirect("/admin");
            return false;
        }

        return true;        //放行
    }
}