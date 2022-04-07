package com.play.java8.function;

import rx.Observable;

/**
 * @ClassName Main
 * @Description TODO
 * @Author szh
 * @Date 2022年04月07日
 */
public class Main {


    public static void main(String[] args){

//        VUtils.isTrue(false).throwMessage("error!");
//        VUtils.isTrue(true).throwMessage("error!");

//        VUtils.ifTrueOrFalse(true).trueOrFalseHandle(() -> {
//            System.out.println("truehandle");
//        },() -> {
//            System.err.println("falsehandle");
//        });


        VUtils.isBlankOrNoBlank("").presentOrElseHandle((str) -> {
            System.out.println(str);
        },() -> {
            System.out.println("我是空的");
        });

        Observable.just("12").subscribe((a) -> {
            System.out.println(a);
        });





    }



}
