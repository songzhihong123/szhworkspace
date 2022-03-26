package com.song.medium;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-11 16:18
 **/
public class _1884 {

    public int twoEggDrop(int n) {
        //dp[i][j] 表示 有 i + 1 枚鸡蛋的时候，验证j层楼所需要的次数
        int[][] dp = new int[2][n + 1];
        dp[0][0] = 0;
        dp[1][0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int j = 1; j <= n; j++) {
            for (int k = 1; k <= j; k++) {
                dp[1][j] = Math.min(dp[1][j] , Math.max(dp[0][k - 1] + 1, dp[1][j - k] + 1));
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args){
        _1884 obj = new _1884();
        int n = 100;
        System.out.println(obj.twoEggDrop(n));
    }


}
