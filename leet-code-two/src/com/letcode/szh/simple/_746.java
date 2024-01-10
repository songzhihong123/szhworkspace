package com.letcode.szh.simple;

/**
 * @ClassName _746
 * @Description _746
 * @Author szh
 * @Date 2024年01月09日
 */
public class _746 {



    public static int minCostClimbingStairs1(int[] cost) {
        int height = cost.length;
        if(height == 2){
            return Math.min(cost[0] , cost[1]);
        }
        return Math.min(process1(cost , 0) , process1(cost , 1));
    }


    // cost 表示数组
    // index 表示当前位置
    public static int process1(int[] cost , int index){

        if(index + 1 == cost.length || index + 2 == cost.length){
            return cost[index];
        }

        return cost[index] + Math.min(process1(cost , index + 1) , process1(cost , index + 2));
    }



    public static int minCostClimbingStairs2(int[] cost) {
        int height = cost.length;
        if(height == 2){
            return Math.min(cost[0] , cost[1]);
        }

        int[] dp = new int[height];
        return Math.min(process2(cost , 0 , dp) , process2(cost , 1 , dp));
    }


    // cost 表示数组
    // index 表示当前位置
    public static int process2(int[] cost , int index , int[] dp){
        if(index + 1 == cost.length || index + 2 == cost.length){
            dp[index] = cost[index];
            return dp[index];
        }

        dp[index] = cost[index] + Math.min(process2(cost , index + 1 , dp) , process2(cost , index + 2 , dp));
        return dp[index];
    }




    public static int minCostClimbingStairs3(int[] cost) {
        int height = cost.length;
        if(height == 2){
            return Math.min(cost[0] , cost[1]);
        }

        int[] dp = new int[height];
        dp[height - 1] = cost[height - 1];
        dp[height - 2] = cost[height - 2];


        for(int i = height - 3 ; i >= 0 ; i--){
            dp[i] = cost[i] + Math.min(dp[i + 1] , dp[i + 2]);

        }

        return Math.min(dp[0] , dp[1]);
    }



    


    public static void main(String[] args) {
        int[] cost = {10 , 15 , 20};
//        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs3(cost));
    }




}
