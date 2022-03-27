package com.atguigu.springboot.config;

import com.atguigu.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {

    //将方法的返回值添加到容器中.容器中这个组件默认ID就是方面名
    @Bean
    public HelloService helloService02(){
        System.out.println("配置类@Bean给容器中添加组件了.....");
        return new HelloService();
    }

}
