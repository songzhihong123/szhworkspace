package com.mmall.concurrent.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CyclicBarrierExample2 {

    private static  CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

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
        try{

            cyclicBarrier.await(2000, TimeUnit.MILLISECONDS);
        }catch (BrokenBarrierException | TimeoutException e){
            log.warn("Exception",e);
        }
        log.info("{} continue",threadNum);
    }

}
