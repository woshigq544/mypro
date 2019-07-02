package com.syjpro.Controllers;

import com.alibaba.fastjson.JSON;
import com.syjpro.entity.Users;
import com.syjpro.finalthings.Finals;
import com.syjpro.services.UserService;
import com.syjpro.util.SecurityUtils;
import com.syjpro.util.TestSign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

//主Controller请求
@Controller
public class MyController {
    private static final Logger log = LoggerFactory.getLogger(MyController.class);
    @Resource
    private UserService userServiceImpl;

    @RequestMapping("/login")
    public String commin(){

        return "redirect:tologin";
    }

    @RequestMapping("/tologin")
    public String comminok(){

        return "pages/login";
    }

    @RequestMapping("/loginup")
    @ResponseBody
    public  String loginok(HttpServletRequest req, HttpServletResponse resp, Users user,String sign,String time) throws IOException, ServletException {
        System.out.println("sign="+sign);
        System.out.println("time="+time);
        boolean bo = false;
        user.setPassword(SecurityUtils.encodeMD5(user.getPassword()));
        user = userServiceImpl.login(user);
        if(user!=null){
            log.info("登录信息验证通过。。。。。。。");
            //登录用户信息验证之后验证签名认证
            if(TestSign.signshowvalues(sign,time)){
                log.info("登录请求验证通过。。。。。。。");
                HttpSession hs = req.getSession();
                //用户登录信息验证通过后将登录用户信息存入session中
                hs.setAttribute(Finals.LOGINUSER,user);
                bo = true;
            }else{
                log.info("登录请求证失败失败，重返登录界面。。。");
            }
        }else{
            log.info("登录信息验证失败，重返登录界面。。。");
        }

        String str= JSON.toJSONString(bo);
        resp.setContentType("text/json;charset=UTF-8");
        return str;
    }

    @RequestMapping("/toindex")
    public String toindex(){
        return "users/emailpage";
    }

    @RequestMapping("/toregist")
    public String toregiste(){
        log.info("注册请求转发中...");
        return "pages/regist";
    }

    @RequestMapping("/registup")
    @ResponseBody
    public  String sureregistuser(HttpServletRequest req, HttpServletResponse resp, Users user,String sign,String time) throws IOException, ServletException {
        boolean bo = false;
        System.out.println("注册用户"+user.getUsername());

        Users usershow = userServiceImpl.toRegist(user);

        if(usershow!=null){
            log.info("账户已存在，注册失败");
        }else{
            log.info("注册信息验证通过。。。。。。。");
            //注册户信息验证之后验证签名认证
            if(TestSign.signshowvalues(sign,time)){
                log.info("账户可以注册");
                user.setCreatetime(new Date());
                user.setPassword(SecurityUtils.encodeMD5(user.getPassword()));
                int a = userServiceImpl.doingRegist(user);
                log.info("注册完毕,注册用户id为 ： "+user.getUserid());

                bo=true;
            }else{
                log.info("注册请求证失败失败，重返登录界面。。。");
            }
        }

        String str= JSON.toJSONString(bo);
        resp.setContentType("text/json;charset=UTF-8");
        return str;
    }


}
