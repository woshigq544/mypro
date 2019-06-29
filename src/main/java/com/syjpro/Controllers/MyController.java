package com.syjpro.Controllers;

import com.alibaba.fastjson.JSON;
import com.syjpro.entity.Users;
import com.syjpro.finalthings.Finals;
import com.syjpro.services.UserService;
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
            System.out.println("登录用户电话号码为："+user.getPhone());
            HttpSession hs = req.getSession();
            //用户登录信息验证通过后将登录用户信息存入session中
            hs.setAttribute(Finals.LOGINUSER,user);
            bo = true;
        }else{
            System.out.println("登录失败");
        }

        String str= JSON.toJSONString(bo);
        resp.setContentType("text/json;charset=UTF-8");
        return str;
    }

    @RequestMapping("/toindex")
    public String toindex(){
        return "users/emailpage";
    }
}
