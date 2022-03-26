package com.imooc.datastructure.stack;

import com.imooc.datastructure.queue.ArrayQueue;
import com.imooc.datastructure.queue.LoopQueue;

import java.util.Random;

public class Main {

    private static double textStack(Stack<Integer> stack , int optCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < optCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < optCount; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args){
        int opCount = 100000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();

        double time1 = textStack(arrayStack,opCount);
        System.out.println("ArrayStack , time: " + time1 + "s");

        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        double time2 = textStack(linkedStack,opCount);
        System.out.println("LinkedStack , time: " + time2 + "s");




    }



}
