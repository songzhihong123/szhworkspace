package com.geely.design.pattern.behavioral.command;

/**
 * Created by Zhihong Song on 2021/1/16 10:35
 */

public class OpenCourseVideoCommand implements Command {

    private CourseVideo courseVideo;

    public OpenCourseVideoCommand(CourseVideo courseVideo) {
        this.courseVideo = courseVideo;
    }

    @Override
    public void excute() {
        courseVideo.open();
    }


}
