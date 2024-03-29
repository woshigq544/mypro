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
public class ShowController {
    private static final Logger log = LoggerFactory.getLogger(ShowController.class);
    @Resource
    private UserService userServiceImpl;



}
