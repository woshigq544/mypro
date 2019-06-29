package com.syjpro.Controllers;

import com.alibaba.fastjson.JSON;
import com.syjpro.entity.Users;
import com.syjpro.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

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

        return "pages/login";
    }

    @RequestMapping("/loginup")
    @ResponseBody
    public  String loginok(HttpServletResponse resp, Users user){
        System.out.println(user);
        PrintWriter pw = null;
        String str= JSON.toJSONString(true);
        resp.setContentType("text/json;charset=UTF-8");
        return str;
    }

    @RequestMapping("/toindex")
    public String toindex(){
        return "users/index";
    }
}
