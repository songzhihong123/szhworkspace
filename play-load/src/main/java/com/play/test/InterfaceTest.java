package com.play.test;

public class InterfaceTest {

    interface interface0{
        int A = 0;
    }

    interface interface1 extends  interface0{
        int A = 1;
    }

    interface  interface2 {
        int A = 2;
    }

    static class Sub implements interface1{
        int A = 3;
    }

    static class Sub1 extends Sub implements interface2{
        int A = 4;
    }


    public static void main(String[] args){

        Sub1 sub1 = new InterfaceTest.Sub1();

        System.out.println(sub1.A);


    }



}
