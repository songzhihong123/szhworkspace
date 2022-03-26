package com.geely.design.pattern.creational.factorymethod;

public class PythonVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制Python的课程视频!");
    }
}
