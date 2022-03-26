package com.song.simple;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Zhihong Song on 2021/1/28 8:30
 */

public class _724 {

    // 1. 枚举法
    public int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = 0;
            for (int j = 0; j < i; j++) {
                left += nums[j];
            }
            for (int j = i + 1; j < nums.length; j++) {
                right += nums[j];
            }
            if(left == right){
                return i;
            }
        }
        return -1;
    }

    // 2. 动态规划
    public int pivotIndex1(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return -1;
        }
        // dp[i][0] 表示下标为i 的左边的总和
        // dp[i][1] 表示下标为i 的右边的总和
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        int asInt = Arrays.stream(nums).map(e -> e).reduce(Integer::sum).getAsInt();
        dp[0][1] = asInt - nums[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i - 1][0] + nums[i - 1];
            dp[i][1] = dp[i - 1][1] - nums[i];
        }
        for (int i = 0; i < len; i++) {
            if(dp[i][0] == dp[i][1]){
                return i;
            }
        }
        return -1;
    }

    // 3.官方解答
    public int pivotIndex2(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return -1;
        }
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if(sum * 2 + nums[i] == total){
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args){
        _724 obj = new _724();
        int[] nums = {1, 7, 3, 6, 5, 6};
//        int[] nums = {1, 2, 3};
        System.out.println(obj.pivotIndex2(nums));
    }


}
