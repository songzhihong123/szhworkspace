package com.geely.design.myself.test1;

import com.geely.design.pattern.behavioral.mediator.User;

import java.util.Random;

/**
 * Created by Zhihong Song on 2021/1/27 16:29
 */

public class Hello {


    String str = new String("good");
    char[] ch = {'a','b','c'};


    public static void main(String[] args){

        Hello hello = new Hello();
        String change = hello.change(hello.str, hello.ch);
        System.out.println(change);
        System.out.print(hello.str + " and ");
        System.out.println(hello.ch);

        System.out.println("==============");
        Double a = (short)10/10.2*2;
        System.out.println(a);

        System.out.println("==================");
        System.out.println("\\likeyou.");

        System.out.println("==================");
        boolean[] b = new boolean[2];
        double[] d = new double[2];
        System.out.println(b[0]);
        System.out.println(d[0]);

        System.out.println("==================");
        System.out.println( 'A' + 1);


    }

    public String change(String str , char[] ch){
        str = "test OK";
        ch[0] = 'g';
        return str;
    }



}
