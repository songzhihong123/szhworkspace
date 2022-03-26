package com.mmall.concurrent.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CyclicBarrierExample3 {

    //在创建的时候加入一个Runnable，是为了让达到屏障的时候先执行这个方法在这个例子中，如果到达5的时候先输出日志
    private static  CyclicBarrier cyclicBarrier = new CyclicBarrier(5,() -> {
        log.info("callback is running");
    });

    public static void main(String[] args) throws Exception{
        ExecutorService service = Executors.newCachedThreadPool();

        for(int i = 0;i<10;i++){
            final int threadNum = i;
            Thread.sleep(1000);
            service.execute(() ->{
                try {
                    rece(threadNum);
                }catch (Exception e){
                    log.error("exception",e);
                }
            });
        }
        service.shutdown();
    }

    private static void rece(int threadNum) throws Exception{
        Thread.sleep(1000);
        log.info("{} is readey",threadNum);
        cyclicBarrier.await();
        log.info("{} continue",threadNum);
    }

}
