package com.yue.springboot_web_demo01.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author yue
 * @description
 * @create 2023-11-08 1:11
 */
@AllArgsConstructor
@Component
@Data
@NoArgsConstructor
@ToString
public class Pet {
    private String name;
    private int age;
}
