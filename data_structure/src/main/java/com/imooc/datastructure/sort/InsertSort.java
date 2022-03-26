package com.imooc.datastructure.sort;


public class InsertSort implements SortClass{

    @Override
    public int[] sort(int[] arr) {

        int len = arr.length;


        for (int i = 1; i < len; i++) {

            int index = i - 1;
            int res = arr[i];
            while(index >= 0 && arr[index] > res){
                index --;
            }

            if(index != i - 1){
                for (int j = i - 1; j > index; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[index + 1] = res;
            }

        }

        return arr;
    }
}
