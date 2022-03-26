package com.song.simple;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-07 16:58
 **/
public class _Offer10_ll {

    public int numWays(int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }


    public static void main(String[] args){
        _Offer10_ll obj = new _Offer10_ll();
        int n = 44;
        System.out.println(obj.numWays(n));
    }



}
