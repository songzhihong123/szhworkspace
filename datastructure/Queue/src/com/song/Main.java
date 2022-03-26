package com.song;

import java.util.Random;

/**
 * 主要区别：
 *     普通队列和循环队列相比较而言，循环队列的出队操作不需要把后面的元素一个一个移动到前面。
 */
public class Main {

    //测试使用q运行opCount个equeue和dequeue操作所需要的时间，单位：秒
    private static double textQueue(Queue<Integer> q,int opCount){
        //以纳秒为单位记录的
        long startTime = System.nanoTime();
        Random random  = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();
        return  (endTime - startTime)/1000000000.0;
    }
    public static void main(String[] args) {
        int opCount = 100000;

        Queue<Integer> arrayQueue = new ArrayQueue<Integer>();
        double tiem1 = textQueue(arrayQueue,opCount);
        System.out.println("ArrayQueue,time :"+tiem1+" s");

        Queue<Integer> loopQueue = new LoopQueue<Integer>();
        double tiem2 = textQueue(loopQueue,opCount);
        System.out.println("LoopQueue,time :"+tiem2+" s");

        Queue<Integer> linkedQueue = new LinckedListQueue<Integer>();
        double tiem3 = textQueue(linkedQueue,opCount);
        System.out.println("LinckedListQueue,time :"+tiem3+" s");
    }
}
