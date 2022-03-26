package com.wiggin.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 10人赛跑，都到达终点的时候才结束
 */
public class CountDownLatchTest {

    final private static int RUNNER_COUNT = 10;

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch beginLatch = new CountDownLatch(1);
        final CountDownLatch endLatch = new CountDownLatch(RUNNER_COUNT);
        final ExecutorService service = Executors.newFixedThreadPool(RUNNER_COUNT);

        for(int i = 0;i<RUNNER_COUNT;i++){
            final int NO = i + 1;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        beginLatch.await();
                        Thread.sleep((int)(Math.random()*1000));
                        System.out.println("NO."+NO+"arrived");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        endLatch.countDown();
                    }
                }
            };
            service.execute(runnable);
        }
        System.out.println("Game Start...");
        beginLatch.countDown();
        endLatch.await();
        System.out.println("Game Over....");
        service.shutdown();
    }

}
