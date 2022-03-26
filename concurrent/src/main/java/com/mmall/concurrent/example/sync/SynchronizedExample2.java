package com.mmall.concurrent.example.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedExample2 {

    public static Logger LOGGER = LoggerFactory.getLogger(SynchronizedExample2.class);

    //修饰一个静态方发下的代码块
    public static void test1(int j){
        synchronized (SynchronizedExample2.class){
           for(int i = 0;i<10;i++) {
               LOGGER.info("test - {}-{}",j,i);
           }
        }
    }
    //修饰一个静态方法
    public synchronized static void test2(int j){
        for(int i = 0;i<10;i++) {
            LOGGER.info("test - {}-{}",j,i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 example1 = new SynchronizedExample2();
        SynchronizedExample2 example2 = new SynchronizedExample2();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(() ->{
            example1.test1(1);
        });
        service.execute(() ->{
            example2.test1(2);
        });
    }



}
