package com.yue.springboot_init_web.controller;

import com.yue.springboot_init_web.bean.Car;
import com.yue.springboot_init_web.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yue
 * @description
 * @create 2023-02-22 20:58
 */
@Controller
public class RequestParamController {
    @ResponseBody
    @RequestMapping("/testParam/{userId}/{password}")
    public Map testParam(@PathVariable("userId")String userId,@PathVariable("password")String password,
                         @RequestParam("age")Integer age){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("password",password);
        map.put("age",age);
        return map;
    }

    @RequestMapping("/params")
    public String testParam(Map<String, Object>map,
                            Model model,
                            ModelMap mp,
                            HttpServletRequest request,
                            HttpServletResponse response){
        map.put("Map","map");
        model.addAttribute("Model","model");
        mp.addAttribute("ModelMap","modelMap");
        request.setAttribute("Request","request");
        response.addCookie(new Cookie("c1","v1"));
        return "forward:/success";
    }


    @ResponseBody
    @GetMapping("/testParam")
    public String testParam(HttpServletRequest request,HttpServletResponse response,String userName){
        System.out.println(userName);
        return userName;
    }

    @RequestMapping("/success")
    @ResponseBody
    public Map success(HttpServletRequest request){
        String map = (String) request.getAttribute("Map");
        String model = (String) request.getAttribute("Model");
        String modelMap = (String) request.getAttribute("ModelMap");
        String requestR = (String) request.getAttribute("Request");

        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("map",map);
        hashMap.put("model",model);
        hashMap.put("modelMap",modelMap);
        hashMap.put("requestR",requestR);
        return hashMap;
    }

    @ResponseBody
    @PostMapping("/saveuser")
    public String saveUser(Person person){

        return person.toString();
    }
    @ResponseBody
    @PostMapping("/saveconv")
    public String saveconv(Person person){
        return person.toString();
    }


}
