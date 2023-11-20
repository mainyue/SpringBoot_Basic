package com.yue.springboot_init_web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author yue
 * @description
 * @create 2023-03-06 2:31
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户数量太多")
public class UserTooManyException extends RuntimeException {
    public UserTooManyException() {
    }

    public UserTooManyException(String message) {
        super(message);
    }
}
