package com.song.sort;

import java.util.Arrays;

public class Charu {


    public static void sort(int[] nums) {
        int len = nums.length;

        for (int i = 1; i < len; i++) {
            int tar = nums[i];
            int j = 0;
            for ( ; j < i; j++) {
                if(tar < nums[j]){
                    break;
                }
            }

            if(i == j){
                continue;
            }

            for (int k = i; k > j; k--) {
                nums[k] = nums[k - 1];
            }
            nums[j] = tar;

        }
        
    }
    
    

    
    public static void main(String[] args){
        int[] target = {5,3,8,4,1};
        sort(target);
        Arrays.stream(target).forEach(System.out::print);
    }

}
