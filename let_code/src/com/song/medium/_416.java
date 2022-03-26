package com.song.medium;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-07 17:50
 **/
public class _416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if((sum & 1) == 1){
            return false;
        }
        int target = sum / 2;
        int len = nums.length;
        boolean[][] dp = new boolean[len][target + 1];
        if(nums[0] <= target){
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            int curr = nums[i];
            for (int j = 0; j <= target; j++) {
                if(j >= curr){
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - curr];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len - 1][target];
    }

    public static void main(String[] args){
        _416 obj = new _416();
        int[] nums = {1,5,11,5};
        System.out.println(obj.canPartition(nums));
    }


}
