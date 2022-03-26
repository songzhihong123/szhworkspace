package com.geely.design.pattern.behavioral.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Zhihong Song on 2021/1/13 21:21
 */

public class Teacher implements Observer {

    private String tracherName;

    public Teacher(String tracherName) {
        this.tracherName = tracherName;
    }

    @Override
    public void update(Observable o, Object arg) {
        Course course = (Course)o;
        Question question = (Question) arg;
        System.out.println(tracherName+"老师的"+course.getCourseName()
                +"课程接收到一个"+question.getUserName()+"提出的问题： " + question.getContext());
    }
}
