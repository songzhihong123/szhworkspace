package com.geely.design.pattern.behavioral.state;

/**
 * Created by Zhihong Song on 2021/1/18 21:23
 */

public class StopState extends CourseVideoState {
    @Override
    public void play() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.PLAY_STATE);
    }

    @Override
    public void pause() {
        System.out.println("ERROR: 停止状态不能暂停！！");
    }

    @Override
    public void speed() {
        System.out.println("ERROR: 停止状态不能快进！！");
    }

    @Override
    public void stop() {
        System.out.println("停止播放课程视频状态");
    }
}
