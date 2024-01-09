package com.letcode.szh.bilibili;

import java.util.LinkedList;

/**
 * @ClassName SlidingWindowMaxArray
 * @Description SlidingWindowMaxArray
 * @Author szh
 * @Date 2024年01月08日
 */
public class SlidingWindowMaxArray {

    /*
    求一个窗口的移动过程中的最大值列表
    定义个双端队列

    // 4 ,3 ,5 ,4 ,3 ,3 ,6 ,7
    整体流程：
        头 4 -> 3 尾
        依次从尾部进入，保持队列里面的值从头到位是从大到小排列的
        加入过程中发现要加入的值比队列里面的值大，则数据依次从尾部弹出，直到这个值可以加入进去

        取最大值就是队列的头部的位置，右指针挪动的时候需要判断上面的操作
        左指针挪动的时候，判断当前值的数字和队列头部最大值是不是相同，相同的话，最大值从队列出去

        例子：4 ,3 ,5 ,4 ,3 ,3 ,6 ,7  窗口长度为3

        队列；
            1、  数组：【4】, 3 ,5 ,4 ,3 ,3 ,6 ,7
                 队列：【4】
            2、  数组：【4 , 3】,5 ,4 ,3 ,3 ,6 ,7
                 队列：【4 -> 3】
            3、  数组：【4 ，3 ，5】,4 ,3 ,3 ,6 ,7
                 队列： 【5】 最大值：5
            4、  数组：4 ，【3 ，5 ,4 】 ,3 ,3 ,6 ,7
                 队列：  【5 ， 4】 最大值：5
            5、  数组：4 ，3 ，【5 ,4 ,3 】,3 ,6 ,7
                 队列：  【5 ， 4 ，3】 最大值：5
            6、  数组：4 ，3 ，5 ,【4 ,3 ,3 】,6 ,7
                队列：  【4 ，3】 最大值：4
            7、  数组：4 ，3 ，5 ,4 , 【3 ,3,6 】,7
                队列：  【6】 最大值：6
            8、  数组：4 ，3 ，5 ,4 , 3 ,【3, 6 ,7】
                队列：  【7】 最大值：7

     */



    public static int[] getMaxWindow(int[] arr , int w){
        if(arr == null || w < 1 || arr.length < w){
            return null;
        }

        LinkedList<Integer> qMax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        int L = -1 , R = 0;
        int start = 0;

        // 4 ,3 ,5 ,4 ,3 ,3 ,6 ,7
        while(R < arr.length){
            while(!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[R]){
                qMax.pollLast();
            }
            qMax.addLast(R);
            if(start >= w - 1){
                if(L >= 0 && arr[qMax.peekFirst()] == arr[L]){
                    qMax.pollFirst();
                }
                res[index++] = arr[qMax.peekFirst()];
                L ++;
            }
            start ++;
            R ++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4 ,3 ,5 ,4 ,3 ,3 ,6 ,7};
        int w = 3;
        int[] maxWindow = getMaxWindow(arr, w);

        for(int i: maxWindow){
            System.out.print(i + " ");
        }


    }



}
