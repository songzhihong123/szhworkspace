package com.geely.design.pattern.creational.simplefactory;

/**
 * 简单工厂
 */
public class Test {

    public static void main(String[] args) {
//        VideoFactory factory = new VideoFactory();
//        Video video = factory.getVideo("python");
//        if (video == null)
//            return;
//        video.produce();
        VideoFactory factory = new VideoFactory();
        Video video = factory.getVideo(JavaVideo.class);
        video.produce();


    }

}
