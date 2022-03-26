package com.mmall.concurrent.example.singleton;


import com.mmall.concurrent.annoation.NotThreadSafe;

/**
 * 懒汉模式 -》 双重同步锁单例模式
 * 单例实例在第一次使用的时候被创建
 */
@NotThreadSafe
public class SinglentonExample4 {

    //私有构造函数
    private SinglentonExample4(){

    }

    //创建对象时候
    //1、memory = allocate() 分配对象的内存空间
    //2、ctroInstance() 初始化对象
    //3、instance = memory 设置instance执行刚分配的内存空间

    //JVM和cpu优化，发生了指令重排

    //1、memory = allocate() 分配对象的内存空间
    //3、instance = memory 设置instance执行刚分配的内存空间
    //2、ctroInstance() 初始化对象



    //单例对象
    private static SinglentonExample4 instance = null;

    //静态的工厂方法
    public static SinglentonExample4 getInstance(){
        if(instance == null){ //双层监测机制
            synchronized (SinglentonExample4.class){ //同步锁
                if(instance == null){
                    instance = new SinglentonExample4();
                }
            }
        }
        return instance;
    }
}
