package com.geely.design.pattern.behavioral.observer;

import java.util.Observable;

/**
 * Created by Zhihong Song on 2021/1/13 21:20
 */

public class Course extends Observable {

    private String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }


    public void produceQuestion(Course course,Question question){
        System.out.println(question.getUserName() + "在"+course.getCourseName() + "提交了一个问题");
        setChanged();
        notifyObservers(question);
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
