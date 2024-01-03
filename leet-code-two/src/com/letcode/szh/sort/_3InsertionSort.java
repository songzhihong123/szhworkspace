package com.letcode.szh.sort;

/**
 * @ClassName _3InsertionSort
 * @Description _3InsertionSort 插入排序
 * @Author szh
 * @Date 2023年12月20日
 */
public class _3InsertionSort {


    /**
     * 1、从第一个元素开始，该元素可以认为已经被排序；
     * 2、取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 3、如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 4、重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 5、将新元素插入到该位置后；
     * 6、重复步骤 2~5。#
     *
     * 时间复杂度：O(n^2)
     */


    public static int[] insertionSort(int[] arr){

        // 第一个for循环是从第一个位置查找到最后一个位置
        for(int i = 1 ; i < arr.length ; i ++){
            // 记录前一个数的下标
            int preIndex = i - 1;
            // 记录当前下标对应的值
            int curr = arr[i];

            // 如果前一个值的标大于等于0 ， 并当前值小于前面下标的值
            while(preIndex >= 0 && curr < arr[preIndex]){
                // 把前面一个值给了后面一个值
                arr[preIndex + 1] = arr[preIndex];
                preIndex --;
            }

            // 把当前值填充到正确的位置上
            arr[preIndex + 1] = curr;

        }

        return arr;
    }


    public static int[] insertionSort1(int[] arr){

        // 第一个for循环是从第一个位置查找到最后一个位置
        for(int i = 1 ; i < arr.length ; i ++){
            for(int j = i - 1 ; j >= 0 && arr[j] > arr[j + 1] ; j--){
                swap(arr , j , j + 1);
            }
        }

        return arr;
    }


    public static void swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void swap1(int[] arr , int i , int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


    public static void main(String[] args) {
        int[] arr = {12 , 3 , 56 , 6 ,10 , 88 , 8};
        int[] ints = insertionSort(arr);

        for(int ar : ints){
            System.out.print(ar + " ");
        }
    }




}
