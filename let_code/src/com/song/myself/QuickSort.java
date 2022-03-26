package com.song.myself;/**
 * Created by Zhihong Song on 2021/4/29 9:10
 */

import java.util.Arrays;

/**
 * @program: let_code
 * @description:
 * @author: szh
 * @create: 2021-04-29 09:10
 **/
public class QuickSort {

    public static void quickSort(int[] arr , int left , int right){
        if(left < right){
            int index = getIndex(arr , left , right);
            quickSort(arr, left , index - 1);
            quickSort(arr , index + 1 , right);
        }
    }


    private static int getIndex(int[] arr , int low , int high){
        int i = low;
        int j = high;
        int tar = arr[i];
        while(i < j){
            while(arr[j] >= tar && i < j){
                j --;
            }
            if(i < j){
                arr[i] = arr[j];
                i ++;
            }
            while(arr[i] <= tar && i < j){
                i ++;
            }
            if(i < j){
                arr[j] = arr[i];
                j --;
            }
        }
        arr[i] = tar;
        return i;
    }


    public static void main(String[] args){
        int[] arr = new int[]{4,1,8,5,3,2,9,10,6,7};
        quickSort(arr,0,arr.length - 1);
        Arrays.asList(arr).forEach(System.out::println);
    }



}
