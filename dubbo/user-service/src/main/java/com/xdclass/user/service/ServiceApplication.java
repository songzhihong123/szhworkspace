package com.xdclass.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportResource;

@EnableAutoConfiguration
@ImportResource("provider.xml")
public class ServiceApplication {
    public static void main(String[] args) {
//        SpringApplication.run(ServiceApplication.class);
        new SpringApplicationBuilder(ServiceApplication.class).web(WebApplicationType.NONE).run();
    }
}
