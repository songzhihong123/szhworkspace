package com.geely.design.pattern.structural.flyweight;


/**
 * Created by Zhihong Song on 2020/11/25 18:35
 *
 * 享元模式
 */

public class Test {

    private static final String departments[] = {"RD","QA","PM","BD"};

    public static void main(String[] args) {
//        for (int i = 0 ; i < 10 ; i ++){
//            String department = departments[(int)(Math.random() * departments.length)];
//            Manager manager = (Manager) EmployeeFactory.getManager(department);
//            manager.report();
//        }


        Integer a = Integer.valueOf(100);
        Integer b = 100;

        Integer c = Integer.valueOf(127);
        Integer d = 127;

        System.out.println(c == d);


    }

}
