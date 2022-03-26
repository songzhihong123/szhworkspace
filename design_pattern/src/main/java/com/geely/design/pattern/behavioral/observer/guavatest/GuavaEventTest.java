package com.geely.design.pattern.behavioral.observer.guavatest;

import com.google.common.eventbus.EventBus;

/**
 * Created by Zhihong Song on 2021/1/13 21:48
 */

public class GuavaEventTest {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        GuavaEvent guavaEvent = new GuavaEvent();
        eventBus.register(guavaEvent);
        eventBus.post("post的内容");
    }

}
