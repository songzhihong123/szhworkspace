package com.mmall.concurrent.example.atomic;

import com.mmall.concurrent.annoation.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

@ThreadSafe
public class AtomicExample3 {

    public static Logger LOOGER = LoggerFactory.getLogger(AtomicExample3.class);
    //请求总数
    public static int clientTotal = 5000;

    //同时并发执行的线程数
    public static int threadTotal = 200;

    public static LongAdder count = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        //定义一个线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //定义一个信号量,信号量的存在是为了一次能够执行多少线程，大于定义的允许执行线程数就会阻塞
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0;i<clientTotal ; i++){
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                }catch (Exception e){
                    LOOGER.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        LOOGER.info("count:{}",count.sum());
    }

    private static  void add(){
//        先做增加操作，在获取当前值
        count.increment();
//        先获取当前值，再做增加操作
//        count.getAndIncrement();
    }

}
