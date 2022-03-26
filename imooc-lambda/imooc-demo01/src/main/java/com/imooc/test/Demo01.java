package com.imooc.test;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-03 20:58
 **/
public class Demo01 {

    public static void main(String[] args) {
        // 1. 传统模式
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread..." + Thread.currentThread().getId());
            }
        }).start();

        // 2.lambda 创建优化线程模式
        new Thread(() -> {
            System.out.println("lambda thread..." + Thread.currentThread().getId());
        }).start();


    }

}
