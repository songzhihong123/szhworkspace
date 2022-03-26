package com.song.simple;

import java.util.Arrays;

/**
 * Created by Zhihong Song on 2021/1/20 15:44
 */

public class _1480 {

    public int[] runningSum(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        
        return nums;
    }

    public static void main(String[] args) {
        _1480 obj = new _1480();
        int[] nums = {1,1,1,1,1};
        Arrays.stream(obj.runningSum(nums)).forEach(System.out::print);
    }


}
