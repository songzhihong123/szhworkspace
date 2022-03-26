package com.xdclass.user.controller;

import com.xdclass.user.service.FileService;
import com.xdclass.user.service.UserService;
//import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class UserController {

//    @Reference(version = "1.0.0")
    @Autowired
    private UserService userService;

    @Autowired
    private FileService fileService;

    @RequestMapping("/sayHello")
    public String sayHello(){
        String s = userService.sayHello();
        return s;
    }

    @RequestMapping("/upload")
    public void upload(@PathParam(value = "msg") String msg){
        fileService.upload(msg);
    }

}
