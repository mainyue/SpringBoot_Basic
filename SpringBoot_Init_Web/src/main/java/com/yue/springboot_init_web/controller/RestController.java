package com.yue.springboot_init_web.controller;

import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author yue
 * @description
 * @create 2023-02-22 13:46
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(){
        return "GET-张三";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String saveUser(){
        return "POST-张三";
    }


    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String putUser(){
        return "PUT-张三";
    }

    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser(){
        return "DELETE-张三";
    }
}
