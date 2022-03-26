package com.geely.design.pattern.creational.builder;

/**
 * Created by Zhihong Song on 2020/10/30 16:22
 * 建造者模式
 */
public class Test {
    public static void main(String[] args) {
        Coach coach = new Coach();
        CourseBuilder courseBuilder = new CourseActualBuilder();
        coach.setCourseBuilder(courseBuilder);
        Course course = coach.makeCourse("java", "ppt", "video", "article", "qa");
        System.out.println(course);

    }
}
