package com.imooc.datastructure.sort;

public class QuickSort implements SortClass{

    @Override
    public int[] sort(int[] targetArr) {
        return sort(targetArr , 0 , targetArr.length - 1);
    }


    private int[]  sort(int[] targetArr , int left , int right){
        if(left > right){
            return targetArr;
        }

        int l = left;
        int r = right;
        int tar = targetArr[l];
        while(l != r){

            while(targetArr[r] >= tar && l < r){
                r --;
            }

            while(targetArr[l] <= tar && l < r){
                l ++;
            }

            int temp = targetArr[l];
            targetArr[l] = targetArr[r];
            targetArr[r] = temp;

        }

        int tmp = targetArr[l];
        targetArr[l] = targetArr[left];
        targetArr[left] = tmp;

        sort(targetArr , left , l - 1);
        sort(targetArr , r + 1 , right);

        return targetArr;
    }


}
