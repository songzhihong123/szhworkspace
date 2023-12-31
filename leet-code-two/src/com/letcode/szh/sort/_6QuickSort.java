package com.letcode.szh.sort;

import java.util.Arrays;

/**
 * @ClassName _6QuickSort
 * @Description 快速排序
 * @Author szh
 * @Date 2023年12月30日
 */
public class _6QuickSort {

    /**
     *
     * 1、从序列中随机挑出一个元素，作为“基准”；
     * 2、重新排列序列，将所有比基准值小的元素摆放在基准前面，所有比基准值大的摆在基准的后面，
     * 相同的树可以到任一边。在这个操作结束之后，该基准就处于数列的中间位置。这个称为分区操作
     * 3、递归的把小于基准元素的子序列和大于基准的子序列进行快速排序
     *
     *
     */



    public static void quickSort(int[] arr){

        quickSort(arr , 0 , arr.length - 1);
    }


    public static void quickSort(int[] arr , int low , int high){
        if(low >= high){
            return ;
        }

        int position = partition(arr , low , high);

        quickSort(arr , low , position - 1);
        quickSort(arr , position + 1 , high);
    }

    public static int  partition(int[] arr , int low , int high){
        int pivot = arr[low];
        int left = low;
        int right = high;

        while(left < right){

            while(left < right && arr[right] >= pivot){
                right --;
            }

            while (left < right && arr[left] <= pivot){
                left ++;
            }

            if(left < right){
                int temp = arr[left];
                arr[left]  = arr[right];
                arr[right] = temp;
            }

        }
        arr[low] = arr[left];
        arr[left] = pivot;

        return left;
    }





    public static void main(String[] args) {
        int[] arr = {12 , 13 , 56 , 6 ,10 , 88 , 8};
        quickSort(arr);

        for(int ar : arr){
            System.out.print(ar + " ");
        }
    }


}
