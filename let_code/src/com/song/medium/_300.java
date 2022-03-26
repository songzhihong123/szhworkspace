package com.song.medium;

import java.util.Arrays;

/**
 * Created by Zhihong Song on 2021/1/25 16:15
 */

public class _300 {


    /**
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     *
     * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     *
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int[] dp = new int[len]; // dp[i] 表示下标 dp[0] - dp[i] 之间最大的递增子序列的长度
        Arrays.fill(dp,1);
        for(int i = 0 ; i < len ; i ++){
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 1;
        for (int i = 0; i < len; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }


    public static void main(String[] args){
        _300 obj = new _300();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(obj.lengthOfLIS(nums));
    }

}
