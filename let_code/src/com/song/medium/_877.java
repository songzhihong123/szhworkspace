package com.song.medium;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-15 13:45
 **/
public class _877 {

    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        //dp[i][j] 表示下标为 i 到 j 的最大差值
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
               dp[i][j] = Math.max(piles[i] - dp[i + 1][j] , piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1] > 0;
    }


    public static void main(String[] args){
        _877 obj = new _877();
        int[] piles = {5,3,4,5};
        System.out.println(obj.stoneGame(piles));
    }



}
