package com.geely.design.pattern.behavioral.mediator;

/**
 * Created by Zhihong Song on 2021/1/16 14:58
 *
 * 中介者模式
 */

public class Test {

    public static void main(String[] args) {
        User geely = new User("Geely");
        User tom = new User("Tom");

        geely.sendMessage("Hey! Tom");
        tom.sendMessage("OK! Geely");
    }

}
