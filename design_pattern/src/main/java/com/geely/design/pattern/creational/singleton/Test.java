package com.geely.design.pattern.creational.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Zhihong Song on 2020/11/2 18:12
 *
 * 单例模式
 */

public class Test {

    public static void main(String[] args) throws Exception{


//        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.out.println("mian Thread: " + ThreadLocalInstance.getInstance());
        System.out.println("mian Thread: " + ThreadLocalInstance.getInstance());
        System.out.println("mian Thread: " + ThreadLocalInstance.getInstance());
        Thread t1 = new Thread(new T());
        Thread t2 = new Thread(new T());
        t1.start();
        t2.start();
//
        System.out.println("program end");

//        HungrySigleton instance = HungrySigleton.getInstance();

//        EnumInstance instance = EnumInstance.getInstance();
//        instance.setData(new Object());
//
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
//        oos.writeObject(instance);
//
//        File file = new File("singleton_file");
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
////        HungrySigleton newInstance = (HungrySigleton)ois.readObject();
//
//        EnumInstance newInstance = (EnumInstance)ois.readObject();
//
//        System.out.println(instance.getData());
//        System.out.println(newInstance.getData());
//
//        System.out.println(instance.getData() == newInstance.getData());


        /**
         * 在类加载的时候创建对象，可以使用反射来放开私有构造器的权限控制
         */

//        Class objectClass = HungrySigleton.class;
//        Class objectClass = StaticInnerClassSingleton.class;
//        Class objectClass = LazySingleton.class;

//        Class objectClass = EnumInstance.class;
//        Constructor constructor = objectClass.getDeclaredConstructor(String.class,int.class);
//        constructor.setAccessible(true);
//        EnumInstance instance = (EnumInstance)constructor.newInstance("Geely",666);



//        HungrySigleton instance = HungrySigleton.getInstance();
//        HungrySigleton newInstance = (HungrySigleton)constructor.newInstance();

//        StaticInnerClassSingleton instance = StaticInnerClassSingleton.getInstance();
//        StaticInnerClassSingleton newInstance = (StaticInnerClassSingleton)constructor.newInstance();



//        LazySingleton instance = LSystem.out.println(instance);
////        System.out.println(newInstance);
////        System.out.pazySingleton.getInstance();
//        LazySingleton newInstance = (LazySingleton)constructor.newInstance();



//        rintln(instance == newInstance);

//        EnumInstance instance = EnumInstance.getInstance();
//        instance.printTest();
    }



}
