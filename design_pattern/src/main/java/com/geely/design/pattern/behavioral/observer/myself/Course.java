package com.geely.design.pattern.behavioral.observer.myself;

import java.util.Observable;

/**
 * Created by Zhihong Song on 2021/1/13 21:20
 */

public class Course {

    private String courseName;
    private Question question;

    public Course(String courseName, Question question) {
        this.courseName = courseName;
        this.question = question;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
