package com.geely.design.pattern.behavioral.command;

/**
 * Created by Zhihong Song on 2021/1/16 10:33
 */

public class CourseVideo {

    private String name;

    public CourseVideo(String name) {
        this.name = name;
    }

    public void open(){
        System.out.println(this.name+" 课程视频开放");
    }

    public void close(){
        System.out.println(this.name+" 课程视频关闭");
    }
}
