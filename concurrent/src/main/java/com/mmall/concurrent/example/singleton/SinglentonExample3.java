package com.mmall.concurrent.example.singleton;

import com.mmall.concurrent.annoation.NotRecommend;
import com.mmall.concurrent.annoation.ThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用的时候被创建
 */
@ThreadSafe
@NotRecommend
public class SinglentonExample3 {

    //私有构造函数
    private SinglentonExample3(){

    }
    //单例对象
    private static SinglentonExample3 instance = null;

    //静态的工厂方法
    public synchronized static SinglentonExample3 getInstance(){
        if(instance == null){
            instance = new SinglentonExample3();
        }
        return instance;
    }
}
