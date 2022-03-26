package com.imooc.datastructure.sort;

public class BubbleSort implements SortClass{

    // int[] targeArr = new int[]{5,4,7,9,0,1};
    @Override
    public int[] sort(int[] targetArr) {
        int len = targetArr.length;
        for(int i = 0 ; i < len ; i++){
            for (int j = 0; j < len - 1 - i ; j++) {
                if(targetArr[j] > targetArr[j + 1]){
                    int temp = targetArr[j];
                    targetArr[j] =  targetArr[j + 1];
                    targetArr[j + 1] = temp;
                }
            }
        }
        return targetArr;
    }
}
