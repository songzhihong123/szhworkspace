package com.song;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

//	    int a = 42;
//        System.out.println(((Integer) a).hashCode());
//
//        int b = -42;
//        System.out.println(((Integer) b).hashCode());
//
//        double c = 3.1415926;
//        System.out.println(((Double) c).hashCode());
//
//        float d = 2.12f;
//        System.out.println(((Float) d).hashCode());
//
//        String e = "imooc";
//        System.out.println(e.hashCode());

        Student stu = new Student(3,2,"BOBO","liu");
        System.out.println(stu.hashCode());

        Set<Student> set = new HashSet<>();
        set.add(stu);

        Map<Student,Integer> scores = new HashMap<>();
        scores.put(stu,90);


        Student stu2 = new Student(3,2,"BOBO","liu");
        System.out.println(stu2.hashCode());


    }
}
