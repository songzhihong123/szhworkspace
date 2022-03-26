package com.song.myself.param;

public class ParamTest {


    public static void main(String[] args){
        Student stu1 = new Student("1","tom");
        Student stu2 = new Student("2","jetty");

        System.out.println(stu1.getName());
        System.out.println(stu2.getName());

        ParamTest.swap(stu1,stu2);

        System.out.println(stu1.getName());
        System.out.println(stu2.getName());



    }

    public static void swap(Student stu1 , Student stu2){
        Student temp = stu1;

        stu1 = stu2;
        stu2 = temp;
//        stu1.setName("tom1");
//        stu2.setName("tom2");

        System.out.println("==============================");
        System.out.println(stu1.getName());
        System.out.println(stu2.getName());
        System.out.println("==============================");


    }



}
