package com.geely.design.pattern.creational.singleton;

/**
 * Created by Zhihong Song on 2020/11/2 18:50
 */

public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton(){
        if (InnerClass.staticInnerClassSingleton != null){
            throw new RuntimeException("单例构造器禁止反射");
        }
    }

    /**
     * 静态内部类的方式
     * 原理：JVM在类的初始化过程当中会有一个加锁的过程
     *  Class对象的初始化锁
     */

    /**
     * 五种情况，首次发生的时候，一个类将被立刻初始化，假设这个类是A
     * 1.有一个A类型的实例被创建。
     * 2.A类中的一个静态方法被调用。
     * 3.A类中的一个静态成员被赋值。
     * 4.A类中的一个静态成员被使用，并且这个成员不是一个常量成员。
     * 5.A类是一个顶级类，并且在这个类重有嵌套的断言语句。
     */
    private static class InnerClass{
        private static StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance(){
        return InnerClass.staticInnerClassSingleton;
    }


}
