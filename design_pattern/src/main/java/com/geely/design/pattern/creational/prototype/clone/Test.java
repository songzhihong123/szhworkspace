package com.geely.design.pattern.creational.prototype.clone;

import com.geely.design.pattern.creational.singleton.HungrySigleton;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by Zhihong Song on 2020/11/12 8:59
 */

public class Test {

    public static void main(String[] args) throws Exception {
        Date birthday = new Date(0L);
        Pig pig1 = new Pig("佩奇",birthday);
        Pig pig2 = (Pig)pig1.clone();
        System.out.println(pig1);
        System.out.println(pig2);

        pig1.getBirthday().setTime(6666666666666666L);
        System.out.println(pig1);
        System.out.println(pig2);

//        HungrySigleton hungrySigleton = HungrySigleton.getInstance();
//        Method method = hungrySigleton.getClass().getDeclaredMethod("clone");
//        method.setAccessible(true);
//        HungrySigleton cloneHungrySigleton = (HungrySigleton)method.invoke(hungrySigleton);
//
//        System.out.println(hungrySigleton);
//        System.out.println(cloneHungrySigleton);
    }

}
