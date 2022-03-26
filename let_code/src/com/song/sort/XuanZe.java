package com.song.sort;

import java.util.Arrays;

public class XuanZe {


    public static void sort(int[] nums){
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if(nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }




    public static void main(String[] args){
        int[] target = {5,3,8,4,1};
        sort(target);
        Arrays.stream(target).forEach(System.out::print);
    }




}
