package com.geely.design.pattern.behavioral.templatemethod;

/**
 * Created by Zhihong Song on 2020/12/23 12:01
 *
 * 模板方法
 */

public class Test {

    public static void main(String[] args) {
        System.out.println("后端设计模式课程start---");
        ACourse designPatternCourse = new DesignPatternCourse();
        designPatternCourse.makeCourse();
        System.out.println("后端设计模式课程end---");

        System.out.println("前端设计模式课程start---");
        ACourse feCourse = new FECourse(false);
        feCourse.makeCourse();
        System.out.println("前端设计模式课程end---");
    }

}
