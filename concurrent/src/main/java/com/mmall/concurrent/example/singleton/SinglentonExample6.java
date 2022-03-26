package com.mmall.concurrent.example.singleton;

import com.mmall.concurrent.annoation.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类加载的时候进行创建
 */
@ThreadSafe
public class SinglentonExample6 {

    //私有构造函数
    private SinglentonExample6(){

    }


    //单例对象
    private static SinglentonExample6 instance = null;

    static {
        instance = new SinglentonExample6();
    }

    //静态的工厂方法
    public static SinglentonExample6 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }


}
