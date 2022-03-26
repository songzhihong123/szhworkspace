package com.geely.design.pattern.creational.singleton;

/**
 * Created by Zhihong Song on 2020/11/2 18:29
 */

public class LazyDoubleCheckSingleton {

    private volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;

    private LazyDoubleCheckSingleton(){

    }

    public static LazyDoubleCheckSingleton getInstance(){
        if (lazyDoubleCheckSingleton == null){
            synchronized (LazyDoubleCheckSingleton.class){
                if (lazyDoubleCheckSingleton == null){
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                    //1.分配内存
                    //2.初始化对象
                    //3.设置lazyDoubleCheckSingleton指向刚分配的内存地址
                    // 正常 1 -> 2 -> 3
                    //重排序 1 -> 3 -> 2
                    // 有可能出现指令重排序的问题 ，加上volatile关键字 不允许指令重排序
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }

}
