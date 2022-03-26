package com.mmall.concurrent.example.singleton;

import com.mmall.concurrent.annoation.NotThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用的时候被创建
 */
@NotThreadSafe
public class SinglentonExample1 {

    //私有构造函数
    private SinglentonExample1(){

    }
    //单例对象
    private static SinglentonExample1 instance = null;

    //静态的工厂方法
    public static SinglentonExample1 getInstance(){
        if(instance == null){
            instance = new SinglentonExample1();
        }
        return instance;
    }
}
