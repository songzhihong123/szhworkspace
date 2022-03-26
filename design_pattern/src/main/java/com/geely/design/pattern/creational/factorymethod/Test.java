package com.geely.design.pattern.creational.factorymethod;

/**
 * 工厂方法
 * 抽象工厂和工厂方法针对的对象不同
 * 抽象工厂：
 *      针对同一个产品族  JavaFactory中获取到的是  javaVideo  和  javaArticle
 * 工厂方法：
 *      针对同一个产品等级  VideoFactory中获取到的是  javaVideo  和  pythonVideo
 */
public class Test {

    public static void main(String[] args) {

        VideoFactory videoFactory = new PythonVideoFactory();
        VideoFactory videoFactory1 = new JavaVideoFactory();
        VideoFactory videoFactory2 = new FEVideoFactory();
        Video video = videoFactory.getVideo();
        video.produce();


    }

}
