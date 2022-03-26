package com.geely.design.pattern.behavioral.command;

/**
 * Created by Zhihong Song on 2021/1/16 10:35
 */

public class CloseCourseVideoCommand implements Command {

    private CourseVideo courseVideo;

    public CloseCourseVideoCommand(CourseVideo courseVideo) {
        this.courseVideo = courseVideo;
    }

    @Override
    public void excute() {
        courseVideo.close();
    }


}
