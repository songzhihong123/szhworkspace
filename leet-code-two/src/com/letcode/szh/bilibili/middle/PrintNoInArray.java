package com.letcode.szh.bilibili.middle;

/**
 * @ClassName PrintNoInArray
 * @Description PrintNoInArray
 * @Author szh
 * @Date 2024年01月15日
 */
public class PrintNoInArray {



    /*

    给定一个长度为n的数组， 数组里面出现的数的范围是1 ～ N之间的数，
    数字之间可能有重复，
    找出1 ～ N 之间没有出现过的数字

    例如：
        [1 , 3 , 4 , 3]

    输出：
        2



     */


    // 保证[0 , N-1] 上的数组都在[1 ~ N] 之间
    public static void printNumberOnArray(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }

//        方法一
//        for(int i = 0 ; i < arr.length ; i++){
//            int value = arr[i];
//            while(arr[value - 1] != value){
//                int temp = arr[value - 1];
//                arr[value - 1] = value;
//                value = temp;
//            }
//        }

        // 方法二，都可以
        int index = 0;
        while(index < arr.length){
            int value = arr[index];
            if(arr[value - 1] != value){
                swap(arr  ,value - 1 , index);
            }else{
                index ++;
            }
        }

        for(int i = 0 ; i < arr.length ; i++){
           if(arr[i] != i + 1){
               System.out.println(i + 1);
           }
        }

    }


    public static void swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4 ,3 ,2 ,5 ,3 ,2};
        printNumberOnArray(arr);
    }





}
