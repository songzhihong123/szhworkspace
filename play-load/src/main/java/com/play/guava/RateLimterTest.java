package com.play.guava;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimterTest {


    public static void main(String[] args) throws InterruptedException {
        testRateLimter();
    }

    public static void testRateLimter() throws InterruptedException {
        RateLimiter rateLimiter = RateLimiter.create(5);
        while(true){
            System.out.println("time: " + rateLimiter.acquire() + "s");
            //线程休眠，给足够的时间产生令牌
            Thread.sleep(1000);
        }

    }






}
