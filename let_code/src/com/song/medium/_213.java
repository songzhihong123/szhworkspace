package com.song.medium;

/**
 * Created by Zhihong Song on 2021/4/15 8:36
 */

public class _213 {

    /**
     * 如果偷窃了第一间房屋，则不能偷窃最后一间房屋，因此偷窃房屋的范围是第一间房屋到最后第二间房屋；
     * 如果偷窃了最后一间房屋，则不能偷窃第一间房屋，因此偷窃房屋的范围是第二间房屋到最后一间房屋。
     * 1 2 3 1
     * 2 1 3 1 4
     */

    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        if(len == 2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(robRange(nums , 0 ,len - 2), robRange(nums , 1 , len - 1));
    }

    public int robRange(int[] nums , int start , int end){
        int first = nums[start];
        int second = Math.max(nums[start] , nums[start + 1]);
        for (int i = start + 2; i <= end ; i++) {
            int temp = second;
            second = Math.max(first + nums[i] , second);
            first = temp;
        }
        return second;
    }


    public int rob1(int[] nums){
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        if(len == 2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp = new int[len];

        dp[1] = nums[1];
        dp[2] = Math.max(nums[1],nums[2]);
        for (int i = 3; i < len; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2] , dp[i - 1]);
        }

        int[] dp1 = new int[len];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < len - 1; i++) {
            dp1[i] = Math.max(nums[i] + dp1[i - 2] , dp1[i - 1]);
        }
        return Math.max(dp[len - 1] , dp1[len - 2]);
    }


    public int rob2(int[] nums){
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        if(len == 2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp = new int[len];

        dp[1] = nums[1];
        dp[2] = Math.max(nums[1],nums[2]);
        for (int i = 3; i < len; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2] , dp[i - 1]);
        }

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < len - 1; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2] , dp[i - 1]);
        }
        return Math.max(dp[len - 1] , dp[len - 2]);
    }


    public static void main(String[] args){
        _213 obj = new _213();
        int[] nums = {1,2,3,1};
        System.out.println(obj.rob1(nums));
    }



}
