package com.song.simple;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-11 15:27
 **/
public class _746 {

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        //dp[i] 表示爬上第i阶话费最小体力
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[len];
    }

    public static void main(String[] args){
        _746 obj = new _746();
        int[] cost = {10, 15, 20};
        System.out.println(obj.minCostClimbingStairs(cost));
    }



}
