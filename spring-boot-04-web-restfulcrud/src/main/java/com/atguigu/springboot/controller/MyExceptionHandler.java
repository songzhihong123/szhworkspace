package com.atguigu.springboot.controller;

import com.atguigu.springboot.exception.UserNotExistException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    //1、浏览器和客户端返回的都是json
   /* @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    public Map<String,Object> handleException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("messgae",e.getMessage());
        return map;
    }*/

    //2、转发到error自适应处理
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        //传入自己错误状态码  否则不会进入自己定制的错误页面，进入错误页面的解析流程
        /*Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");*/
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        request.setAttribute("ext",map);
        return "forward:/error";
    }

}
