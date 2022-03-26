package com.mmall.concurrent.example.singleton;


import com.mmall.concurrent.annoation.NotThreadSafe;
import com.mmall.concurrent.annoation.ThreadSafe;

/**
 * 懒汉模式 -》 双重同步锁单例模式
 * 单例实例在第一次使用的时候被创建
 */
@ThreadSafe
public class SinglentonExample5 {

    //私有构造函数
    private SinglentonExample5(){

    }

    //创建对象时候
    //1、memory = allocate() 分配对象的内存空间
    //2、ctroInstance() 初始化对象
    //3、instance = memory 设置instance执行刚分配的内存空间

    //使用 volatile 关键字就不会发生指令重排了

    //单例对象  volatile + 双层监测机制 ->  禁止指令重排
    private volatile static SinglentonExample5 instance = null;

    //静态的工厂方法
    public static SinglentonExample5 getInstance(){
        if(instance == null){ //双层监测机制
            synchronized (SinglentonExample5.class){ //同步锁
                if(instance == null){
                    instance = new SinglentonExample5();
                }
            }
        }
        return instance;
    }
}
