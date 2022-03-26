package com.geely.design.pattern.behavioral.observer.guavatest;

import com.google.common.eventbus.Subscribe;

/**
 * Created by Zhihong Song on 2021/1/13 21:47
 */

public class GuavaEvent {

    @Subscribe
    public void subscribe(String str){
        System.out.println("执行subscribe方法，传入的参数是: " + str);
    }

}
