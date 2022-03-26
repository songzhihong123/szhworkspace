package com.geely.design.pattern.behavioral.observer.myself;

import com.google.common.eventbus.Subscribe;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Zhihong Song on 2021/1/13 21:21
 */

public class Teacher{

    private String tracherName;

    public Teacher(String tracherName) {
        this.tracherName = tracherName;
    }

    @Subscribe
    public void update(Course course) {
        System.out.println(tracherName+"老师的"+course.getCourseName()
                +"课程接收到一个"+course.getQuestion().getUserName()+"提出的问题： " + course.getQuestion().getContext());
    }
}
