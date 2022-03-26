package com.geely.design.pattern.behavioral.observer.myself;

import com.google.common.eventbus.EventBus;

/**
 * Created by Zhihong Song on 2021/1/13 21:29
 *
 * 观察者模式
 */

public class Test {

    public static void main(String[] args) {

        EventBus eventBus = new EventBus();
        Question question = new Question();
        question.setUserName("Geely");
        question.setContext("Java主函数如何创建");
        Course course = new Course("Java设计模式精讲",question);

        Teacher teacher = new Teacher("Ailea");
        eventBus.register(teacher);

        eventBus.post(course);


    }

}
