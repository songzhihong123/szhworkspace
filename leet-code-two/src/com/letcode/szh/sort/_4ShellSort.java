package com.letcode.szh.sort;

/**
 * @ClassName _4ShellSort
 * @Description _4ShellSort 希尔排序
 * @Author szh
 * @Date 2023年12月24日
 */
public class _4ShellSort {


    /**
     *
     * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，
     * 待整个序列中的记录“基本有序”时，在对全体记录进行依次直接插入排序
     *
     * 时间复杂度：O(nlogn)
     */



    public static int[] shellSort(int[] arr){

        int n = arr.length;
        int gap = n / 2;

        while(gap > 0){
            for(int i = gap ; i < n ; i++){
                int current = arr[i];
                int preIndex = i - gap;

                while(preIndex >= 0 && arr[preIndex] > current){
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = current;
            }
            gap /= 2;
        }

        return arr;
    }



    public static void main(String[] args) {
        int[] arr = {12 , 3 , 56 , 6 ,10 , 88 , 8};
        int[] ints = shellSort(arr);

        for(int ar : ints){
            System.out.print(ar + " ");
        }
    }

}
