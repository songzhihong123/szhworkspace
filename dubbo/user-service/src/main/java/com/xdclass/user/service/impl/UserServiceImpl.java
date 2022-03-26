package com.xdclass.user.service.impl;

import com.xdclass.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.dubbo.config.annotation.Service;

//@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public String sayHello() {
        LOGGER.info("该方法被调用");
        /*try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return "hello";
    }
}
