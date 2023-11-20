package com.yue.springboot_web_demo01.bean;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @author yue
 * @description
 * @create 2023-11-08 1:10
 */
@AllArgsConstructor
@Component
@Data
@NoArgsConstructor
@ToString
public class User {
    private String name;
    private int age;
    private String birth;
    private Pet pet;
}
