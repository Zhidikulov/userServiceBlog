package com.example.userServiceBlog.config;

import lombok.ToString;

@ToString
public class UserException extends RuntimeException{

    private String errorCode;
    public UserException(String errorCode){
        this.errorCode = errorCode;
    }
}
