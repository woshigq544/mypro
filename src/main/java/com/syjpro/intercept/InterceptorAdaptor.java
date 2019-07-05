package com.syjpro.intercept;

import com.syjpro.entity.Users;
import com.syjpro.finalthings.Finals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InterceptorAdaptor extends HandlerInterceptorAdapter {
    private static final Logger log = LoggerFactory.getLogger(InterceptorAdaptor.class);

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
            /*System.out.println("百度所谓的项目名 ："+request.getScheme()+"://"+ request.getServerName()+request.getRequestURI());*/
            String path = request.getContextPath();
            log.info("通过拦截获取的path为："+path);
            log.info("request.getRequestURI()为："+request.getRequestURI());
            //getScheme()获取http协议
            String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
            log.info("请求"+basePath+"被拦截");
            //可根据是否有项目名称输入自行判断请求路径斜杠


            if(request.getRequestURI().contains("show") || request.getRequestURI().contains("common")){
                bo = true;
            }
            if(!bo){
                response.sendRedirect(basePath+"tologin");
            }

            /*System.out.println("getRequestURL方法返回客户端发出请求时的完整URL"+request.getRequestURL());
            System.out.println("getRequestURI方法返回请求行中的资源名部分"+request.getRequestURI());
            System.out.println("getPathInfo方法返回请求URL中的额外路径信息。额外路径信息是请求URL中的位于Servlet的路径之后和查询参数之前的内容，它以“/”开头"+request.getPathInfo());
            System.out.println("getRemoteAddr方法返回发出请求的客户机的IP地址"+request.getRemoteAddr());
            System.out.println("getRemoteHost方法返回发出请求的客户机的完整主机名"+request.getRemoteHost());
            System.out.println("getRemotePort方法返回客户机所使用的网络端口号"+request.getRemotePort());
            System.out.println("getLocalAddr方法返回WEB服务器的IP地址"+request.getLocalAddr());
            System.out.println("getLocalName方法返回WEB服务器的主机名"+request.getLocalName());*/
            
        }
        return bo;
    }
}
