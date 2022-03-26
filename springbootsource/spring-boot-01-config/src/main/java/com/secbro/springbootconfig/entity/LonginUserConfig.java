package com.secbro.springbootconfig.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Zhihong Song on 2021/4/7 16:18
 */
@Component
@ConfigurationProperties(prefix = "user")
public class LonginUserConfig {

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
