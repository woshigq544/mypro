package com.mails.intercept;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InterceptorAdaptor extends HandlerInterceptorAdapter {
    /**
     * @auther: gq
     * @param handler
     * @return: boolean
     * @date: 2019/4/10 17:56
     * 重写preHandle方法（预处理）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        return false;
    }
}
