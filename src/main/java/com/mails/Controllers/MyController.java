package com.mails.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//主Controller请求
@Controller
public class MyController {
    @RequestMapping("/login")
    public String commin(){

        return "redirect:tologin";
    }
    @RequestMapping("/tologin")
    public String comminok(){

        return "pages/login";
    }

    @PostMapping("/loginrup")
    @ResponseBody
    public boolean loginok(){
        System.out.println("进了");
        return true;
    }

    @RequestMapping("/toindex")
    public String toindex(){
        return "users/index";
    }
}
