package com.geely.design.pattern.creational.singleton;

/**
 * Created by Zhihong Song on 2020/11/5 19:28
 */

public class ThreadLocalInstance {

    private static final ThreadLocal<ThreadLocalInstance> threadLocalInstance
            = new ThreadLocal<ThreadLocalInstance>(){
        @Override
        protected ThreadLocalInstance initialValue() {
            return new ThreadLocalInstance();
        }
    };

    private ThreadLocalInstance(){

    }

    public static ThreadLocalInstance getInstance(){
        return threadLocalInstance.get();
    }

}
