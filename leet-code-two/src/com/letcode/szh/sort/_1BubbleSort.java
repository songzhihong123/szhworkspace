package com.letcode.szh.sort;

/**
 * @ClassName _1BubbleSort
 * @Description 冒泡排序
 * @Author szh
 * @Date 2023年12月19日
 */
public class _1BubbleSort {


    /**
     *  每次把最大的冒到最后一个位置
     *
     *  时间复杂度：O(n^2)
     */
    public static int[] bubbleSort(int[] arr){

        // 第一个For循环表示循环需要比较多少次
        for(int i = 1 ; i < arr.length ; i ++){
            // 第二个FOR循环是真正的比较
            for(int j = 0 ; j < arr.length - i ; j ++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {12 , 3 , 56 , 6 ,10 , 88 , 8};
        int[] ints = bubbleSort(arr);

        for(int ar : ints){
            System.out.print(ar + " ");
        }
    }


}
