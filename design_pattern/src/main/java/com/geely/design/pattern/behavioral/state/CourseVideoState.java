package com.geely.design.pattern.behavioral.state;

/**
 * Created by Zhihong Song on 2021/1/18 21:20
 */

public abstract class CourseVideoState {

    protected CourseVideoContext courseVideoContext;

    public void setCourseVideoContext(CourseVideoContext courseVideoContext) {
        this.courseVideoContext = courseVideoContext;
    }

    public abstract void play();
    public abstract void pause();
    public abstract void speed();
    public abstract void stop();

}
