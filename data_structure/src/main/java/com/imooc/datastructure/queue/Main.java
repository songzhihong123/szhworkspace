package com.imooc.datastructure.queue;

import java.util.Random;

public class Main {

    private static double textQueue(Queue<Integer> queue , int optCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < optCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < optCount; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args){
        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();

        double time1 = textQueue(arrayQueue,opCount);
        System.out.println("ArrayQueue , time: " + time1 + "s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = textQueue(loopQueue,opCount);
        System.out.println("LoopQueue , time: " + time2 + "s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = textQueue(linkedListQueue,opCount);
        System.out.println("LinkedListQueue , time: " + time3 + "s");


    }



}
