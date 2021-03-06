package com.song.medium;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-11 09:09
 **/
public class _279 {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min , dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }

    public static void main(String[] args){
        _279 obj = new _279();
        int n = 12;
        System.out.println(obj.numSquares(n));
    }


}
