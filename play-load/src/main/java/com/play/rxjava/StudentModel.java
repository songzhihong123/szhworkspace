package com.play.rxjava;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StudentModel {

    private static List<Student> studentList;

    public static void init(){
        studentList = new ArrayList<>();
        Stream.iterate(0 , t -> t + 1).limit(10).forEach(i -> {
            Student s = new Student();
            List<Student.Course> courses = new ArrayList<>();
            Stream.iterate(0 , t -> t + 1).limit(3).forEach(j -> {
                Student.Course c = new Student.Course();
                c.setCourseName("Course " + j);
                courses.add(c);
            });
            s.setName("Student " + i);
            s.setCourseList(courses);
            studentList.add(s);
        });
    }

    public static List<Student> getStudentList() {
        return studentList;
    }
}
