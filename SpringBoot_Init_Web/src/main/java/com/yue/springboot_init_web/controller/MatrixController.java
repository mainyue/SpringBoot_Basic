package com.yue.springboot_init_web.controller;

import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yue
 * @description
 * @create 2023-02-23 1:06
 */
@RestController
public class MatrixController {
    @RequestMapping("/cars/{path}")
    public Map carsSell(@PathVariable("path")String path , @MatrixVariable("low")String low
            , @MatrixVariable("brand")List<String> brand){
        HashMap<String, Object> map = new HashMap<>();
        map.put("path",path);
        map.put("low",low);
        map.put("brand",brand);
        System.out.println("=================================");
        System.out.println(path);
        System.out.println("=================================");
        return map;
    }

    //"/boss/1;age=20/2;age=19"
    @RequestMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age",pathVar = "bossId")String age1
            ,@MatrixVariable(value = "age",pathVar = "empId")String age2){
        HashMap<String, Object> map = new HashMap<>();
        map.put("bossId's age",age1);
        map.put("empId's age",age2);
        return map;
    }
}
