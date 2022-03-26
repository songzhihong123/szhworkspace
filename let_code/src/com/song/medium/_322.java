package com.song.medium;

import java.util.Arrays;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-11 11:08
 **/
public class _322 {


    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < len; j++) {
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i] , dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    public static void main(String[] args){
        _322 obj = new _322();
        int coins[] = {474,83,404,3};
        int amount = 264;
        System.out.println(obj.coinChange(coins, amount));
    }



}
