package com.geely.design.pattern.behavioral.state;

/**
 * Created by Zhihong Song on 2021/1/18 21:23
 */

public class PlayState extends CourseVideoState{

    @Override
    public void play() {
        System.out.println("正常播放课程视频状态");
    }

    @Override
    public void pause() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.PAUSE_STATE);
    }

    @Override
    public void speed() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.SPEED_STATE);
    }

    @Override
    public void stop() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.STOP_STATE);
    }


}
