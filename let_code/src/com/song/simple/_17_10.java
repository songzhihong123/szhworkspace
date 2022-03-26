package com.song.simple;

import java.util.Arrays;


public class _17_10 {

    public int majorityElement(int[] nums) {
        // 1 2 5 5 5 5 9 9
        Arrays.sort(nums);
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        int n = (int) Math.ceil(Double.valueOf(nums.length)/ 2);
        if(len % 2 == 0){
            n = len / 2;
        }
        int count = 1;
        for (int i = 1; i < len; i++) {
            if(nums[i] == nums[i - 1]){
                count ++;
            }else{
                count = 1;
            }
            if(count >= n){
                return nums[i - 1];
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        _17_10 obj = new _17_10();
        int[] nums = {3 , 2 , 3};
        System.out.println(obj.majorityElement(nums));
    }

}
