package com.geely.design.pattern.behavioral.state;

/**
 * Created by Zhihong Song on 2021/1/18 21:40
 */

public class Test {

    public static void main(String[] args) {

        CourseVideoContext courseVideoContext = new CourseVideoContext();
        courseVideoContext.setCourseVideoState(new PlayState());

        System.out.println("当前状态：" + courseVideoContext.getCourseVideoState().getClass().getName());

        courseVideoContext.pause();

        System.out.println("当前状态：" + courseVideoContext.getCourseVideoState().getClass().getName());

        courseVideoContext.speed();

        System.out.println("当前状态：" + courseVideoContext.getCourseVideoState().getClass().getName());

        courseVideoContext.stop();

        System.out.println("当前状态：" + courseVideoContext.getCourseVideoState().getClass().getName());

        courseVideoContext.speed();
    }

}
