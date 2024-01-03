package com.letcode.szh.bilibili;

import java.util.PriorityQueue;

/**
 * @ClassName SortArrDistanceLessK
 * @Description SortArrDistanceLessK
 * @Author szh
 * @Date 2024年01月03日
 */
public class SortArrDistanceLessK {

    /**
     *
     * 已知一个几乎有序的数据，几乎有序是指，如果把数组排好顺序的话，每个
     * 元素移动的距离可以不超过k，并且k相当于数据来说比较小。请选择一个合适
     * 的排序算法针对这个数据进行排序
     *
     *
     */

    public static void sortArrDistanceLessK(int[] arr , int k){

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int n = Math.min(arr.length , k);

        int index = 0;

        for( ; index < n ; index ++){
            queue.add(arr[index]);
        }
        int i = 0;
        for(; index < arr.length ; index++){
            queue.add(arr[index]);
            arr[i++] = queue.poll();
        }

        while(!queue.isEmpty()){
            arr[i++] = queue.poll();
        }





    }




}
