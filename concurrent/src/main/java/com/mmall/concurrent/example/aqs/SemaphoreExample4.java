package com.mmall.concurrent.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SemaphoreExample4 {

    private static int threadCount = 20;

    public static void main(String[] args) throws Exception{

        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);

        for(int i = 0;i<threadCount;i++){
            final int threadNum = i;
            executorService.execute(() ->{
                try {
                    if(semaphore.tryAcquire(5000, TimeUnit.MILLISECONDS)){//尝试获取一个许可
                        test(threadNum);
                        semaphore.release();//释放一个许可
                    }
                } catch (Exception e) {
                    log.error("exception",e);
                }
            });
        }
        log.info("finish");
        executorService.shutdown();
    }

    private static void test(int threadNum) throws Exception{
        log.info("{}",threadNum);
        Thread.sleep(1000);
    }

}
