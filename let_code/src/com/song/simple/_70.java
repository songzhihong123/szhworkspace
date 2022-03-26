package com.song.simple;

import java.util.Arrays;

/**
 * Created by Zhihong Song on 2021/1/11 17:31
 */

public class _70 {

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * 解：到达n阶 只能由 n-1 阶上来 或者是由 n-2 阶上来
     * 所以：F(n) = F(n-1) + F(n-2)
     */

    public static void main(String[] args) {
        _70 obj = new _70();
        System.out.println(obj.climbStairs4(4));
    }


    /**
     * 方法一：递归
     */
    public int climbStairs1(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return climbStairs1(n - 1 ) + climbStairs1(n - 2);
    }

    /**
     * 方法二：记忆化递归
     */
    public int climbStairs2(int n) {
        int[] memo = new int[n + 1];
        return climbStairsMemo(memo,n);
    }

    private int climbStairsMemo(int[] memo, int n){
        if(memo[n] > 0){
            return memo[n];
        }
        if(n == 1){
            memo[n] = 1;
        }else if(n == 2){
            memo[n] = 2;
        }else {
            memo[n] = climbStairsMemo(memo,n - 1 ) + climbStairsMemo(memo,n - 2);
        }
        return memo[n];
    }

    /**
     * 方法三：动态规划
     */
    public int climbStairs3(int n) {
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        Arrays.stream(dp).forEach(System.out::print);
        System.out.println();
        return dp[n];
    }

    /**
     * 方法四：斐波那契数列
     */
    public int climbStairs4(int n) {
        if(n == 1){
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
          int third = first + second;
          first = second;
          second = third;
        }
      return second;
    }

}
