package com.yue.springboot_web_demo01.controller;

import com.yue.springboot_web_demo01.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yue
 * @description
 * @create 2023-11-09 0:24
 */
@Controller
public class ResponseParamController {
    @RequestMapping("/testResponseNegotiation")
    @ResponseBody
    public User testResponseNegotiation(User user) {
        return user;
    }
}
