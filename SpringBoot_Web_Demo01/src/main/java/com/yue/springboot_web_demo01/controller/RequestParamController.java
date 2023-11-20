package com.yue.springboot_web_demo01.controller;

import com.yue.springboot_web_demo01.bean.Car;
import com.yue.springboot_web_demo01.bean.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yue
 * @description
 * @create 2023-11-07 21:57
 */
@Controller
public class RequestParamController {
    @ResponseBody
    @RequestMapping("/testParam/{userId}/{password}")
    public Map testParam(@PathVariable("userId") String userId, @PathVariable("password") String password,
                         @RequestParam("age") Integer age) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("password", password);
        map.put("age", age);
        return map;
    }

    @ResponseBody
    @RequestMapping("/testRequestParam")
    public String testRequestParam(HttpServletRequest request) {
        String age = request.getParameter("age");
        return age;
    }

    //cars/sell;low=34;brand=byd,audi,yd
    @ResponseBody
    @RequestMapping("/cars/{path}")
    public Map testMaxtrix(@MatrixVariable("low") String low
            , @MatrixVariable("brand") List<String> brand
            , @PathVariable("path") String path) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;
    }

    @ResponseBody
    @RequestMapping("/saveuser")
    public Map testPojo(User user) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("name", user.getName());
        map.put("age", user.getAge());
        map.put("birth", user.getBirth());
        map.put("pet", user.getPet());
        return map;
    }

    @ResponseBody
    @RequestMapping("/myconverter")
    public Map testPojoConverter(User user) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("name", user.getName());
        map.put("age", user.getAge());
        map.put("birth", user.getBirth());
        map.put("pet", user.getPet());
        return map;
    }

    @RequestMapping("/testReturn/cars/{sell}")
    @ResponseBody
    public Car testReturn(@PathVariable("sell") String sell
            , @MatrixVariable(pathVar = "sell", value = "low") Integer low
            , @MatrixVariable(pathVar = "sell", value = "brand") List brand) {
        return new Car(low, brand);
    }

    @RequestMapping("/testModel/cars/{path}")
    @ResponseBody
    public String testModel(@MatrixVariable(pathVar = "path", value = "low") Integer low
            , @MatrixVariable(pathVar = "path", value = "brand") List brand, Model model) {
        model.addAttribute("car",new Car(low,brand));
        return "success";
    }
}
