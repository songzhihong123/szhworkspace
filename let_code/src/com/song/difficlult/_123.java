package com.song.difficlult;

/**
 * Created by Zhihong Song on 2021/1/9 19:24
 */

public class _123 {

    /**
     对于任意一天考虑四个变量:
     buy1: 在该天第一次买入股票可获得的最大收益
     shell1: 在该天第一次卖出股票可获得的最大收益
     buy2: 在该天第二次买入股票可获得的最大收益
     shell2: 在该天第二次卖出股票可获得的最大收益
     分别对四个变量进行相应的更新, 最后shell2就是最大
     收益值(shell2 >= shell1)
     */
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;
        int shell1 = 0;
        int buy2 = -prices[0];
        int shell2 = 0;
        for (int price : prices) {
            buy1 = Math.max(buy1,-price);
            shell1 = Math.max(shell1,price + buy1);
            buy2 = Math.max(buy2,shell1 - price);
            shell2 = Math.max(shell2,price + buy2);
        }
        return shell2;


    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        _123 obj = new _123();
        System.out.println(obj.maxProfit(prices));
        System.out.println(Integer.MIN_VALUE / 2);
    }

}
