package com.song.simple;

/**
 * Created by Zhihong Song on 2021/1/12 16:39
 */

public class _42 {

    /**
     * 超出内存限制
     */
    public int maxSubArray1(int[] nums) {
        if(nums.length == 0){
            return -1;
        }
        int len = nums.length;
        int[][] dp = new int[len][len]; //dp[i][j] 表示nums中下标为i - j 的和
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len ; i++){
            for (int j = i; j < len; j++) {
                if(i == j){
                    dp[i][j] = nums[i];
                }else {
                    dp[i][j] = dp[i][j - 1] + nums[j];
                }
                res = Math.max(res,dp[i][j]);
            }
        }
        return res;
    }

    /**
     * 超出时间限制
     */
    public int maxSubArray2(int[] nums) {
        if(nums.length == 0){
            return -1;
        }
        int len = nums.length;
        int temp = nums[0];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len ; i++){
            for (int j = i; j < len; j++) {
                if(i == j){
                    temp = nums[i];
                }else {
                    temp = temp + nums[j];
                }
                res = Math.max(res,temp);
            }
        }
        return res;
    }

    public int maxSubArray3(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return -1;
        }
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            nums[i] = Math.max(nums[i-1] , 0) + nums[i];
            res = Math.max(nums[i],res);
        }
        return res;
    }



    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        _42 obj = new _42();
        System.out.println(obj.maxSubArray3(nums));
    }

}
