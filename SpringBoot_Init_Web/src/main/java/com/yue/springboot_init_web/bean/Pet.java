package com.yue.springboot_init_web.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

/**
 * @author yue
 * @description
 * @create 2023-02-26 1:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pet {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        if (!Objects.equals(name, pet.name)) return false;
        return Objects.equals(age, pet.age);
    }

    private String name;
    private String age;
}
