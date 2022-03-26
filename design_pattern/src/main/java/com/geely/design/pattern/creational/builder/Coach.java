package com.geely.design.pattern.creational.builder;

/**
 * Created by Zhihong Song on 2020/10/30 16:24
 */

public class Coach {

    private CourseBuilder courseBuilder;

    public Course makeCourse(String courseName,String coursePPT,String courseVideo,String courseArticle,String courseQA){
        courseBuilder.buildCourseName(courseName);
        courseBuilder.buildCoursePPT(coursePPT);
        courseBuilder.buildCourseVideo(courseVideo);
        courseBuilder.buildCourseArticle(courseArticle);
        courseBuilder.buildCourseQA(courseQA);
        return courseBuilder.build();
    }

    public CourseBuilder getCourseBuilder() {
        return courseBuilder;
    }

    public void setCourseBuilder(CourseBuilder courseBuilder) {
        this.courseBuilder = courseBuilder;
    }

}
