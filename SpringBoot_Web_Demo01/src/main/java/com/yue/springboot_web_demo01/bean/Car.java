package com.yue.springboot_web_demo01.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author yue
 * @description
 * @create 2023-11-08 12:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car {
    int low;
    List<String> brand;
}
