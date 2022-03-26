package com.mmall.concurrent.example.singleton;

import com.mmall.concurrent.annoation.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类加载的时候进行创建
 */
@ThreadSafe
public class SinglentonExample2 {

    //私有构造函数
    private SinglentonExample2(){

    }
    //单例对象
    private static SinglentonExample2 instance = new SinglentonExample2();

    //静态的工厂方法
    public static SinglentonExample2 getInstance(){
        return instance;
    }
}
