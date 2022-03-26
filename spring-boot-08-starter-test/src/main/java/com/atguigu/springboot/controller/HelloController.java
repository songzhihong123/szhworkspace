package com.atguigu.springboot.controller;

import com.atguigu.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;


    @RequestMapping("/hello")
    public String hello(){
        String hha = helloService.sayHelloAtguigu("hha");
        return hha;

    }

}
