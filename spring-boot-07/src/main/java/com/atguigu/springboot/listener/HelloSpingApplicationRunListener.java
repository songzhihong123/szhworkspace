package com.atguigu.springboot.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class HelloSpingApplicationRunListener implements SpringApplicationRunListener {

    public HelloSpingApplicationRunListener(SpringApplication application, String[] args) {

    }

    @Override
    public void starting() {
        System.out.println("SpringApplicationRunListener...starting....");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment configurableEnvironment) {
        Object o = configurableEnvironment.getSystemProperties().get("os.name");
        System.out.println("SpringApplicationRunListener...environmentPrepared.."+o);
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("SpringApplicationRunListener...contextPrepared..");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("SpringApplicationRunListener...configurableApplicationContext...");
    }

    @Override
    public void finished(ConfigurableApplicationContext configurableApplicationContext, Throwable throwable) {
        System.out.println("SpringApplicationRunListener....finished...");
    }
}
