package com.yue.springboot_init_web.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private String userName;
    private String password;
    //以下是数据库字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
