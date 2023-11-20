package com.yue.springboot_init_web.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.Objects;

/**
 * @author yue
 * @description
 * @create 2023-02-26 1:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    private String userName;
    private Integer age;
    private Date birth;
    private Pet pet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(userName, person.userName) && Objects.equals(age, person.age) && Objects.equals(birth, person.birth) && Objects.equals(pet, person.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, age, birth, pet);
    }
}
