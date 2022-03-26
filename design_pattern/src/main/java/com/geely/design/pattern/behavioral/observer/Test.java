package com.geely.design.pattern.behavioral.observer;

/**
 * Created by Zhihong Song on 2021/1/13 21:29
 *
 * 观察者模式
 */

public class Test {

    public static void main(String[] args) {
        Course course = new Course("Java设计模式精讲");
        Teacher teacher = new Teacher("Alpha");
        course.addObserver(teacher);

        //业务逻辑代码
        Question question = new Question();
        question.setUserName("Geely");
        question.setContext("Java的主函数如何编写");

        course.produceQuestion(course,question);

    }

}
