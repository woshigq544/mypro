package com.mails.Controllers;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
    public  void loginok(@RequestParam("callback")String callback, HttpServletResponse resp){
        System.out.println("进了");
        String str= JSON.toJSONString(true);
        resp.setContentType("text/json;charset=UTF-8");
        PrintWriter pw = null;
        try {
            pw = resp.getWriter();
            pw.println();
            pw.println(callback+"("+str+")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/toindex")
    public String toindex(){
        return "users/index";
    }
}
