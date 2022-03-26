package com.mmall.concurrent.example.concurrent;

import com.mmall.concurrent.annoation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.*;

@Slf4j
@ThreadSafe
public class ConcurrentSkipListMapExample {

    private static Map<Integer,Integer> map = new ConcurrentSkipListMap<>();
    //请求总数
    public static int clientTotal = 5000;

    //同时并发执行的线程数
    public static int threadTotal = 200;

    public static void main(String[] args) throws InterruptedException {
        //定义一个线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //定义一个信号量,信号量的存在是为了一次能够执行多少线程，大于定义的允许执行线程数就会阻塞
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0;i<clientTotal ; i++){
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update(count);
                    semaphore.release();
                }catch (Exception e){
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        log.info("size:{}",map.size());
    }

    private  static void update(int i){
        map.put(i,i);
    }

}
