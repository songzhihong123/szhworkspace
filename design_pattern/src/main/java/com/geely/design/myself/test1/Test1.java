package com.geely.design.myself.test1;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Zhihong Song on 2021/2/28 11:03
 */

public class Test1 {


    public static void main(String[] args) {

        int x = 4;
        System.out.println((x>4)? 99.9 : 9);

        System.out.println(get());


    }



    public static int get(){
        try{
            return 1;
        }finally {
            return 2;
        }
    }



    public static int[] quickSort(int[] target, int left , int right){

        int mid = target[left];

        //  6,4,2,8
        // 2 , 4 , 6, 8
       while(left < right){

           while(target[left + 1] < mid){
               left ++;
           }

           while(target[right] > mid){
               right --;
           }

           int temp = target[left];
           target[left] = target[0];
           target[0] = temp;

           quickSort(target, 0, left);
           quickSort(target, right, target.length - 1);

       }

       return target;
    }


}
