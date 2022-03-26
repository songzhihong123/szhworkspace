package com.imooc.datastructure.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {



    public static void main(String[] args){
        int[] targeArr = new int[]{5,4,7,9,0,1};

//        int[] result = testSort(new BubbleSort(), targeArr);
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }

//        int[] result = testSort(new QuickSort(), targeArr);
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }

//        int[] result = testSort(new InsertSort(), targeArr);
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }

        int[] result = testSort(new SelectSort(), targeArr);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }





    }


    public static int[] testSort(SortClass sortClass,int[] targetArr){
        return sortClass.sort(targetArr);
    }




}
