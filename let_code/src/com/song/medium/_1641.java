package com.song.medium;

/**
 * Created by Zhihong Song on 2021/1/13 8:25
 */

public class _1641 {

    /**
     * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
     *
     * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
     *
     */

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int countVowelStrings(int n) {

        int[][] dp = new int[n+1][5]; //dp[n][0-4] 表示长度为n ，以元音字母结尾的[a-u]的个数
        for (int i = 0 ; i < 5 ; i++){
            dp[1][i] = 1;
        }
        for(int i = 2;i <= n; i++){
            dp[i][4] = dp[i-1][4] + dp[i-1][3] + dp[i-1][2] + dp[i-1][1] + dp[i-1][0];
            dp[i][3] = dp[i-1][3] + dp[i-1][2] + dp[i-1][1] + dp[i-1][0];
            dp[i][2] = dp[i-1][2] + dp[i-1][1] + dp[i-1][0];
            dp[i][1] = dp[i-1][1] + dp[i-1][0];
            dp[i][0] = dp[i-1][0];
        }
        return dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4];
    }

    /**
     * 排列组合
     * @param n
     * @return
     */
    public int countVowelStrings1(int n) {

        /**
         * n 个小球放在m个盒子里面的，允许盒子为空，有多少种方法
         *
         * 若一开始m和盒子里面都有一个小球，那么总共有 n + m 个小球，那么在不允许盒子为空的情况下，
         * 把 n + m 个小球 放入 m 个盒子里面会怎么样?
         *
         * n + m 个小球则有 n + m - 1 个间隙。然后在  n + m - 1 寻找 m - 1 个间隙把 n + m 个小球分为 m 份，之后在从每个盒子里面拿出来一个小球
         * 则是 C(上 m-1  下 n+m-1)
         *
         *
         * 推广开来，我们有n个长度，首先给aeiou预留长度，则有 n + 5 个长度
         * 把 n + 5 -1 个间隙里面插入 4 个间隙分为 5 份，
         * 则是 C(上4  下 n+5-1)
         */

        return ((n + 4) * (n + 3)* (n + 2)* (n + 1)) / (4*3*2*1);
    }



    public static void main(String[] args) {
        _1641 obj = new _1641();
        int n = 5;
        System.out.println(obj.countVowelStrings(5));
    }

}
