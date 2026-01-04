package com.codenote.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 * 检查用户是否已登录，未登录则跳转到登录页面
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取Session
        HttpSession session = request.getSession();

        // 检查是否已登录
        Object user = session.getAttribute("loginUser");

        if (user != null) {
            // 已登录，放行
            return true;
        }

        // 未登录，跳转到登录页面
        response.sendRedirect(request.getContextPath() + "/login");
        return false;
    }
}
