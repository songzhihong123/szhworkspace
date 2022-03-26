package com.mmall.concurrent.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class FutureExample {

     private static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            log.info("do something");
            Thread.sleep(5000);
            return "Done";
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future =  executorService.submit(new MyCallable());
        log.info("do something in main");
        Thread.sleep(1000);
        String result = future.get();//如果没有返回结果则会一直阻塞在这个地方
        log.info("result:{}",result);
        executorService.shutdown();
    }


}
