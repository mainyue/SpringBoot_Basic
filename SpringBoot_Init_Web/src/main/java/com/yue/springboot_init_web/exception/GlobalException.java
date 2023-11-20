package com.yue.springboot_init_web.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author yue
 * @description
 * @create 2023-03-06 1:25
 */
@Slf4j
@ControllerAdvice
public class GlobalException {
    //处理异常
    @ExceptionHandler({ArithmeticException.class, NullPointerException.class})
    public String handleArithException(Exception e){

        log.error("异常是：{}",e);
        return "index";
    }
}
