package com.atguigu.cache.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class IlleagRequestExceptionHadler {


    @ExceptionHandler(IlleagRequestException.class)
    @ResponseBody
    public String hadle(){

        return "{\"code\": 403}";
    }



}
