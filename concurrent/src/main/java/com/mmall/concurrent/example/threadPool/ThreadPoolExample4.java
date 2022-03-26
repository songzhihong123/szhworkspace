package com.mmall.concurrent.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadPoolExample4 {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        /*scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                log.warn("scedule run");
            }
        },3, TimeUnit.SECONDS);*/
        /**
         * 延时一秒，隔三秒运行一次
         */
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                log.warn("scedule run");
            }
        },1,3,TimeUnit.SECONDS);
//        scheduledThreadPool.shutdown();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.warn("scedule run");
            }
        },new Date(),5*1000);
    }
}
