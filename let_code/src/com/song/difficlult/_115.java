package com.song.difficlult;

/**
 * Created by Zhihong Song on 2021/3/17 20:47
 */

public class _115 {


    /**
     * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
     *
     */


    public int numDistinct(String s, String t) {

        int m = s.length();
        int n = t.length();
        if (m < n) {
            return 0;
        }

        //其中 dp[i][j] 表示在 s[i:] 的子序列中 t[j:] 出现的个数。
        int[][] dp = new int[m + 1 ][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        for (int i = m - 1; i >= 0 ; i--) {
            char sChar = s.charAt(i);
            for (int j = n - 1; j >= 0 ; j--) {
                char tChar = t.charAt(j);
                if(sChar == tChar){
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                }else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args){
        String s = "babgbag";
        String t = "bag";
        _115 obj = new _115();
        System.out.println(obj.numDistinct(s, t));

    }

}
