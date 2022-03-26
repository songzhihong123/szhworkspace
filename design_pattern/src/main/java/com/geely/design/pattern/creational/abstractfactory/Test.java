package com.geely.design.pattern.creational.abstractfactory;

/**
 * 抽象工厂
 * 抽象工厂和工厂方法针对的对象不同
 * 抽象工厂：
 *      针对同一个产品族  JavaFactory中获取到的是  javaVideo  和  javaArticle
 * 工厂方法：
 *      针对同一个产品等级  VideoFactory中获取到的是  javaVideo  和  pythonVideo
 */
public class Test {

    public static void main(String[] args) {

        CourseFactory factory = new JavaCourseFactory();
        Video video = factory.getVideo();
        Article article = factory.getArticle();
        video.produce();
        article.produce();

    }
}
