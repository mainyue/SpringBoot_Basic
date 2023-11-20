package com.yue.springboot_init_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yue
 * @description
 * @create 2023-03-04 13:51
 */
@Controller
public class IndexController {
    @GetMapping("/login")
    public String mainIndex(){
        return "login";
    }

    @RequestMapping("/index")
    public String index(){
        int i =10/0;
        return "index";
    }
}
