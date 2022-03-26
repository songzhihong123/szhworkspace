package com.geely.design.pattern.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhihong Song on 2021/1/17 10:20
 *
 * 访问者模式
 */

public class Test {

    public static void main(String[] args) {
        List<Course> courseList = new ArrayList<>();

        FreeCourse freeCourse = new FreeCourse();
        freeCourse.setName("SpringMVC 数据绑定");

        CodingCourse codingCourse = new CodingCourse();
        codingCourse.setPrice(299);
        codingCourse.setName("Java设计模式");

        courseList.add(freeCourse);
        courseList.add(codingCourse);

        courseList.forEach(course -> course.accept(new Visitor()));

    }

}
