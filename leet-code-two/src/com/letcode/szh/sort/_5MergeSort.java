package com.letcode.szh.sort;

import java.util.Arrays;

/**
 * @ClassName _5MergeSort
 * @Description 归并排序
 * @Author szh
 * @Date 2023年12月24日
 */
public class _5MergeSort {

    /**
     *
     * 归并排序是一个递归的过程， 边界条件为当输入序列仅有一个元素时，直接返回
     *
     * 1、如果输入内只有一个元素，则直接返回，否则将长度为n的输入序列分为两个长度为n/2的子序列
     * 2、分别对这两个子序列进行归并排序，使子序列变为有序状态
     * 3、设定两个指针，分别指向两个已经排序子序列的起始位置
     * 4、比较两个指针所指向的元素，选择相对想的元素放入合并空间（用于存放排序结果），并移动指针到下个位置
     * 5、重复步骤3～4知道某一个指针到序列尾部
     * 6、将另一序列剩下的所有元素直接复制到合并序列尾部
     *
     *
     * 时间复杂度：
     *
     */


    public static int[] mergeSort(int[] arr){
        if(arr.length <= 1){
            return arr;
        }

        int middle = arr.length / 2;

        int[] arr_1 = Arrays.copyOfRange(arr , 0 , middle);
        int[] arr_2 = Arrays.copyOfRange(arr , middle, arr.length);

        return merge(mergeSort(arr_1) , mergeSort(arr_2));
    }


    public static int[] merge(int[] arr_1 , int[] arr_2){
        int[] sort_arr = new int[arr_1.length + arr_2.length];

        int idx =  0 , idx_1 = 0 ,  idx_2 = 0;

        while(idx_1 < arr_1.length && idx_2 < arr_2.length){
          if(arr_1[idx_1] < arr_2[idx_2]){
              sort_arr[idx] = arr_1[idx_1];
              idx_1 ++;
          }else {
              sort_arr[idx] = arr_2[idx_2];
              idx_2 ++;
          }
          idx ++;
        }


        if(idx_1 < arr_1.length){
            while (idx_1 < arr_1.length){
                sort_arr[idx] = arr_1[idx_1];
                idx_1 ++;
                idx ++;
            }
        }else{
            while (idx_2 < arr_2.length){
                sort_arr[idx] = arr_2[idx_2];
                idx_2 ++;
                idx ++;
            }
        }

        return sort_arr;
    }





    public static void main(String[] args) {
        int[] arr = {12 , 3 , 56 , 6 ,10 , 88 , 8};
        int[] ints = mergeSort(arr);

        for(int ar : ints){
            System.out.print(ar + " ");
        }
    }




}
