package com.song.medium;

/**
 * Created by Zhihong Song on 2021/4/3 16:54
 */

public class _1143 {

    //动态规划

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1 ; i <= m ; i ++){
            char char1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char char2 = text2.charAt(j - 1);
                if(char1 == char2){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args){
        _1143 obj = new _1143();
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(obj.longestCommonSubsequence(text1, text2));
    }


}
