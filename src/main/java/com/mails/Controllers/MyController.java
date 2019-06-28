package com.mails.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String loginok(){
        return "redirect:toindex";
    }

    @RequestMapping("/toindex")
    public String toindex(){
        return "users/index";
    }
}
