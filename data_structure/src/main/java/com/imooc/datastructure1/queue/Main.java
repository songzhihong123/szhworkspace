package com.imooc.datastructure1.queue;

import com.imooc.datastructure1.queue.ArrayQueue;

import java.util.Random;

/**
 * @ClassName Main
 * @Description Main
 * @Author szh
 * @Date 2023年07月16日
 */
public class Main {

    private static double testQueue(Queue<Integer> q , int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0 ; i< opCount ; i ++){
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0 ; i< opCount ; i ++){
            q.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;

    }


    public static void main(String[] args) {
        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        System.out.println("ArrayQueue , time: " + testQueue(arrayQueue , opCount) + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();

        System.out.println("LoopQueue , time: " + testQueue(loopQueue , opCount) + " s");
    }




}
