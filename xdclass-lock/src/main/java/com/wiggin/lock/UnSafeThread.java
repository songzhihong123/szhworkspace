package com.wiggin.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class UnSafeThread {
    private static int num = 0;


    private static CountDownLatch countDownLatch = new CountDownLatch(10);

//    private static ReentrantLock lock = new ReentrantLock();
    private static ZkLock lock = ZkLock.getInstance();
    /**
     * 每次对num进行++操作
     */
    public static void inCreate(){
        lock.lock(1);
        num ++;
        lock.unLock(1);
    }

    public static void main(String[] args){
        for(int i = 0;i<10;i++){
             new Thread(() -> {
                for (int j = 0;j<100;j++){
                    inCreate();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //每个线程执行完之后
                 countDownLatch.countDown();
             }).start();
        }

        while (true){
            if(countDownLatch.getCount() == 0){
                System.out.println(num);
                break;
            }
        }


    }




}

