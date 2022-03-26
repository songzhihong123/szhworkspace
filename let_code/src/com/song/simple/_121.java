package com.song.simple;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-11 14:53
 **/
public class _121 {


    public int maxProfit(int[] prices) {
        int len = prices.length;
        // dp[i] 表示在第i天可以获得的最大利润
        int[] dp = new int[len + 1];
        dp[0] = 0;
        for (int i = 1; i < len; i++) {
            dp[i] =  Math.max(0,(dp[i - 1] - prices[i - 1] + prices[i]));
        }
        int res = 0;
        for (int i : dp) {
            res = Math.max(i ,res);
        }
        return res;
    }


    public int maxProfit1(int[] prices) {
        int len = prices.length;
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i; j < len; j++) {
                int diff = prices[j] - prices[i];
                res = Math.max(res , diff);
            }
        }
        return res;
    }

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if(prices[i] < min){
                min = prices[i];
            }else{
                res = Math.max(res,prices[i] - min);
            }
        }
        return res;
    }


    public static void main(String[] args){
        _121 obj = new _121();
        int[] prices = {7,6,4,3,1};
        System.out.println(obj.maxProfit2(prices));
    }


}
