package com.letcode.szh.sort;

/**
 * @ClassName _2SelectionSort
 * @Description 选择排序
 * @Author szh
 * @Date 2023年12月19日
 */
public class _2SelectionSort {


    /**
     *
     * 每次找到最小的值放到第一位，然后找到第二小的放在第二个位置
     *
     * 时间复杂度：O(n^2)
     *
     */



    public static int[] selectionSort(int[] arr){


        // 第一层的for循环：每一次循环都找到一个最小的值与当前位置的数据交换位置
        for(int i = 0 ; i < arr.length - 1 ; i ++ ){

            int minIndex = i;

            // 第二层的for循环，找到数据最小的数的存储的位置
            for(int j = i + 1 ; j < arr.length ; j ++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }

            if(minIndex != i){
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }

        }

        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {12 , 3 , 56 , 6 ,10 , 88 , 8};
        int[] ints = selectionSort(arr);

        for(int ar : ints){
            System.out.print(ar + " ");
        }
    }




}
