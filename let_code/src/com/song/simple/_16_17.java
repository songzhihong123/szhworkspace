package com.song.simple;

/**
 * Created by Zhihong Song on 2021/1/13 22:13
 */

public class _16_17 {

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1] , 0);
            max = Math.max(max,nums[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        _16_17 obj = new _16_17();
        System.out.println(obj.maxSubArray(nums));
    }

}
