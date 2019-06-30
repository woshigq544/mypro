package com.syjpro.intercept;

import com.syjpro.entity.Users;
import com.syjpro.finalthings.Finals;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        HttpSession hs = request.getSession();
        Users user = (Users)hs.getAttribute(Finals.LOGINUSER);
        boolean bo = false;
        if(user!=null){
            bo = true;
        }else{
            String path = request.getContextPath();
            //getScheme()获取http协议
            String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
            System.out.println("请求"+basePath+"被拦截");
            response.sendRedirect("/login");
        }
        return bo;
    }
}
