package com.yue.springboot_init_web.controller;

import com.yue.springboot_init_web.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author yue
 * @description
 * @create 2023-02-26 20:10
 */
@Controller
public class ResponseController {
    @ResponseBody
    @GetMapping("/testPerson")
    public Person   getPerson(){
        Person  person = new Person();
        person.setAge(12);
        person.setUserName("张三");
        person.setBirth(new Date());
        return person;
    }
}
