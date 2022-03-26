package com.geely.design.pattern.creational.builder.v2;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

/**
 * Created by Zhihong Song on 2020/10/30 16:44
 */

public class Test {

    public static void main(String[] args) {
        Course build = new Course.CourseBuilder().buildCourseName("java")
                .buildCoursePPT("ppt").buildCourseVideo("video")
                .buildCourseQA("qa").build();
        System.out.println(build);

        Set<String> set = ImmutableSet.<String>builder().add("a").add("b").build();
        System.out.println(set);



    }

}
