package com.imooc.datastructure.sort;

public class SelectSort implements SortClass{
    @Override
    public int[] sort(int[] targetArr) {
        
        int len = targetArr.length;

        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                minIndex = targetArr[j] < targetArr[minIndex] ? j : minIndex;
            }
            if(minIndex != i){
                int temp = targetArr[i];
                targetArr[i] = targetArr[minIndex];
                targetArr[minIndex] = temp;
            }
        }
        
        return targetArr;
    }
}
