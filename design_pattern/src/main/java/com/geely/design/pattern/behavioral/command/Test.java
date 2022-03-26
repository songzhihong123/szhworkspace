package com.geely.design.pattern.behavioral.command;

/**
 * Created by Zhihong Song on 2021/1/16 10:41
 *
 * 命令模式
 */

public class Test {

    public static void main(String[] args) {
        CourseVideo  courseVideo = new CourseVideo("Java设计模式精讲 -- By Geely");

        OpenCourseVideoCommand openCourseVideoCommand = new OpenCourseVideoCommand(courseVideo);
        CloseCourseVideoCommand closeCourseVideoCommand = new CloseCourseVideoCommand(courseVideo);

        Staff staff = new Staff();
        staff.addCommand(openCourseVideoCommand);
        staff.addCommand(closeCourseVideoCommand);
        staff.executeCommand();


    }

}
