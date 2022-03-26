package com.mmall.concurrent.example.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedExample1 {

    public static Logger LOGGER = LoggerFactory.getLogger(SynchronizedExample1.class);

    //修饰一个代码块
    public void test1(int j){
        synchronized (this){
           for(int i = 0;i<10;i++) {
               LOGGER.info("test - {}-{}",j,i);
           }
        }
    }
    //修饰一个方法
    public synchronized void test2(int j){
        for(int i = 0;i<10;i++) {
            LOGGER.info("test - {}-{}",j,i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(() ->{
            example1.test2(1);
//            example1.test2();
        });
        service.execute(() ->{
//            example1.test1();
            example2.test2(2);
        });
    }



}
