package com.geely.design.pattern.behavioral.state;

/**
 * Created by Zhihong Song on 2021/1/18 21:23
 */

public class SpeedState extends CourseVideoState {

    @Override
    public void play() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.PLAY_STATE);
    }

    @Override
    public void pause() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.PAUSE_STATE);
    }

    @Override
    public void speed() {
        System.out.println("快进播放课程视频状态");
    }

    @Override
    public void stop() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.STOP_STATE);
    }
}
