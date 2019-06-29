package com.syjpro.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


@Controller
public class EmailsController {

    private static final Logger log = LoggerFactory.getLogger(EmailsController.class);


    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String from;

    @RequestMapping("/mails")
    public String backManage( HttpServletResponse hrs,HttpServletRequest request){
        String path = request.getContextPath();
        //getScheme()获取http协议
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

        PrintWriter pw = null;
        String valueaj = "";
        try {
                System.setProperty("java.net.preferIPv4Stack" , "true");
                //spring包含一个邮件模块
                MimeMessage mimeMessage = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
                helper.setSubject("密码找回邮件");
                //邮件内容设置
                helper.setText("<b style='color:red'>免费小游戏连接为：</b><a href='http://www.4399.com'>小游戏</a>，该邮件30分钟内有效，请尽快处理！",true);
                //邮件发送的目的地
                helper.setTo(request.getParameter("email"));
                //邮箱平台，企业邮箱，个人邮箱
                helper.setFrom(from);

                mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "backok";
    }

    @RequestMapping("/good")
    public String backManage(){
        return "go";
    }
}
