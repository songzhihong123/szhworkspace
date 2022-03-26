package com.song.sort;

import java.util.Arrays;

public class Kuaisu {


    public static void quickSort(int[] num){
        sort(num,  0 , num.length - 1);
    }



    public static void sort(int[] num , int low , int high){

        if(low > high){
            return;
        }

        int base = num[low];
        int i = low;
        int j = high;

        while(i < j){

            while(base >= num[i] && i < j){
                i ++;
            }

            while(base <= num[j] && i < j){
                j --;
            }

            if(i < j){
                int t = num[i];
                num[i] = num[j];
                num[j] = t;
            }

        }

        num[low] = num[i];
        num[i] = base;

        sort(num , low , i - 1);
        sort(num , i + 1 , high);

    }





    public static void main(String[] args){
        int[] target = {5,3,8,4,1};
        quickSort(target);
        Arrays.stream(target).forEach(System.out::print);
    }
}
