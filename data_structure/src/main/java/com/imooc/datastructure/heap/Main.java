package com.imooc.datastructure.heap;

import java.util.Random;

public class Main {

    private static double testHeap(Integer[] testData , boolean isHeapify){
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if(isHeapify){
            maxHeap = new MaxHeap<>(testData);
        }else{
            maxHeap = new MaxHeap<>();
            for (int num : testData) {
                maxHeap.add(num);
            }
        }

        int n = testData.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < n; i++) {
            if(arr[i - 1] < arr[i]){
                throw new IllegalArgumentException("Errpr");
            }
        }
        long endTime = System.nanoTime();
        return (endTime - startTime)/1000000000.0;
    }

    public static void main(String[] args){

        int n = 1000000;

       Integer[] testData = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }

        double time1 = testHeap(testData,false);
        System.out.println("Without heapify : "+  time1 + " s ");

        double time2 = testHeap(testData, true);
        System.out.println("With heapify : "+  time2 + " s ");

    }



}
