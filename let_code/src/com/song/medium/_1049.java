package com.song.medium;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-08 09:31
 **/
public class _1049 {

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int stone : stones){
            sum += stone;
        }
        int len = stones.length;
        int m = sum / 2;
        boolean[][] dp = new boolean[len + 1][m + 1];
        dp[0][0] = true;
        for (int i = 0; i < len; i++) {
            int stone = stones[i];
            for (int j = 0; j <= m; j++) {
                if(stone > j){
                    dp[i + 1][j] = dp[i][j];
                }else {
                    dp[i + 1][j] = dp[i][j] | dp[i][j - stone];
                }
            }
        }
        for (int i = m;  ; -- i) {
            if(dp[len][i]){
                return sum - 2 * i;
            }
        }
    }


    public static void main(String[] args){
        _1049 obj = new _1049();
        int[] stones = {31,26,33,21,40};
        System.out.println(obj.lastStoneWeightII(stones));
    }


}
