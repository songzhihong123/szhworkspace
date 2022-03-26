package com.secbro.springbootconfig.controller;

import com.secbro.springbootconfig.entity.LonginUserConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Zhihong Song on 2021/4/7 16:17
 */

@RestController
public class ConfigController {

    @Value("${user.username}")
    private String username;

    @Value("${user.password}")
    private String password;

    @Resource
    private LonginUserConfig longinUserConfig;

    @Value("${projectName:unknown}")
    private String projectName;

    @RequestMapping("/")
    public String getConfigParams(){
        System.out.println("Commond config projectName : " + projectName);

        System.out.println("Application config Username : " + username);
        System.out.println("Application config Password : " + password);


        System.out.println("ConfigurationProperties config username : " + longinUserConfig.getUsername());
        System.out.println("ConfigurationProperties config password : " + longinUserConfig.getPassword());

        return "";
    }
}
