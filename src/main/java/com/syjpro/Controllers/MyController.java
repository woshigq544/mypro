package com.syjpro.Controllers;

import com.alibaba.fastjson.JSON;
import com.syjpro.entity.Users;
import com.syjpro.finalthings.Finals;
import com.syjpro.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

        return "index";
    }

    @RequestMapping("/loginup")
    @ResponseBody
    public  String loginok(HttpServletRequest req, HttpServletResponse resp, Users user){
        boolean bo = false;
        System.out.println("登录用户"+user.getUsername());
        user = userServiceImpl.login(user);
        if(user!=null){
            log.info("登录信息验证通过。。。。即将跳转。。。。");
            HttpSession hs = req.getSession();
            //用户登录信息验证通过后将登录用户信息存入session中
            hs.setAttribute(Finals.LOGINUSER,user);
            bo = true;
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
        System.out.println("进来注册？？？");
        return "pages/regist";
    }

    @RequestMapping("/registup")
    @ResponseBody
    public  String sureregistuser(HttpServletRequest req, HttpServletResponse resp, Users user){
        boolean bo = false;
        System.out.println("注册用户"+user.getUsername());

        Users usershow = userServiceImpl.toRegist(user);

        if(usershow!=null){
            System.out.println("账户已存在，注册失败");
        }else{
            System.out.println("账户可以注册");
            int a = userServiceImpl.doingRegist(user);
            System.out.println("注册完毕");
            bo=true;
        }

        String str= JSON.toJSONString(bo);
        resp.setContentType("text/json;charset=UTF-8");
        return str;
    }
}
