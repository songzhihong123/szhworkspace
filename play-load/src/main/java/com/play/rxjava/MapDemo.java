package com.play.rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

import java.util.List;

public class MapDemo {


    public static void main(String[] args){
        StudentModel.init();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                List<Student> studentList = StudentModel.getStudentList();
//                studentList.forEach(stu -> {
//                    List<Student.Course> courseList = stu.getCourseList();
//                    courseList.forEach(course -> {
//                        System.out.println(course);
//                    });
//                });
//            }
//        }).start();

//        Observable.from(StudentModel.getStudentList())
//                .map(new Func1<Student, List<Student.Course>>() {
//                    @Override
//                    public List<Student.Course> call(Student student) {
//
//                        return student.getCourseList();
//                    }
//                }).subscribe(new Subscriber<List<Student.Course>>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable throwable) {
//
//                    }
//
//                    @Override
//                    public void onNext(List<Student.Course> courses) {
//                        courses.forEach(System.out::println);
//                    }
//        });

        Observable.from(StudentModel.getStudentList()).flatMap(new Func1<Student, Observable<?>>() {
            @Override
            public Observable<?> call(Student student) {
                return null;
            }
        }).subscribe(new Subscriber<Object>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(Object o) {

            }
        });




    }









}
