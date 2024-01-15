package com.letcode.szh.middle;

import java.util.Arrays;

/**
 * @ClassName _518
 * @Description _518
 * @Author szh
 * @Date 2024年01月14日
 */
public class _518 {


    public static int change(int amount, int[] coins) {

        return process(coins , 0 ,amount);
    }


    public static int process(int[] coins , int index , int restAmount){
        if(restAmount == 0){
            return 1;
        }
        if(restAmount < 0){
            return 0;
        }

        int count = 0;

        for(int i = index; i < coins.length ; i ++){
            count += process(coins , i , restAmount - coins[i]);
        }


        return count;
    }




    public static int change1(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return process1(coins , 0 ,amount , dp);
    }


    public static int process1(int[] coins , int index , int restAmount , int[][] dp){
        if(restAmount == 0){
            dp[index][restAmount] = 1;
            return 1;
        }
        if(restAmount < 0){
            return 0;
        }
        if(dp[index][restAmount] != -1){
            return dp[index][restAmount];
        }

        int count = 0;

        for(int i = index; i < coins.length ; i ++){
            count += process1(coins , i , restAmount - coins[i] , dp);
        }
        dp[index][restAmount] = count;

        return count;
    }


    public static int change2(int amount, int[] coins) {
        int N = coins.length;
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        for(int i = 0 ; i < N ; i ++){
            dp[i][0] = 1;
        }
        for(int i = 1 ; i <= amount ; i++){
            if(i % coins[N - 1] == 0){
                dp[N - 1][i] = 1;
            }else{
                dp[N - 1][i] = 0;
            }
        }

        for(int target = 1 ; target <= amount ; target ++){
            for(int i = N - 1 ; i >= 0 ; i --){

                int count = 0;
                for(int j = i; j < N ; j ++){
                    if(target - coins[j] >= 0 ){
                        count += dp[j][target - coins[j]];
                    }
                }
                dp[i][target] = count;
            }
        }

        return dp[0][amount];
    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println(change(amount , coins));
        System.out.println(change1(amount , coins));
        System.out.println(change2(amount , coins));
    }


}
