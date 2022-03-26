package com.geely.design.pattern.creational.singleton;

/**
 * Created by Zhihong Song on 2020/11/2 18:14
 */

public class T implements Runnable {

    @Override
    public void run() {
//        LazySingleton lazySingleton = LazySingleton.getInstance();
//        LazyDoubleCheckSingleton lazyDoubleCheckSingleton = LazyDoubleCheckSingleton.getInstance();
//        StaticInnerClassSingleton staticInnerClassSingleton = StaticInnerClassSingleton.getInstance();
//        ContainerSingleton.putInstance("object",new Object());
//        Object object = ContainerSingleton.getInstance("object");

        ThreadLocalInstance instance = ThreadLocalInstance.getInstance();

        System.err.println(instance);
    }

}
