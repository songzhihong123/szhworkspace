package com.letcode.szh.bilibili.middle;

import java.util.Arrays;

/**
 * @ClassName SnackBag
 * @Description SnackBag
 * @Author szh
 * @Date 2024年01月14日
 */
public class SnackBag {

    /*

   牛牛准备参加学校组织的春游，出发前牛牛准备往背包里装入一些零食， 牛牛的背包容量为w。
   牛牛家里一共有n袋子零食， 第i袋的零食体积为v[i]。
   牛牛想知道在总体积不超过背包容量的情况下，他一共有多少种零食放法(总体积为0也算一种放法)

     */


    public static int sankBag(int[] arr , int w){


        return process(arr , 0 , w);
    }


    // arr 为零食数组，index为当前位置 restW 为背包剩余容量
    // 返回共有多少中零食放法
    public static int process(int[] arr , int index , int total){
        if(total == 0){
            return 1;
        }else if(total < 0){
            return 0;
        }

        if(index >= arr.length){
            return 1;
        }

        //可以选择要或者是不要

        // a. 不要当前位置
        int res = process(arr , index + 1 , total);

        // 当前位置的体积大于剩余体积，那就只能不要当前位置
        // b.要当前位置
        int currWeight = arr[index];
        if(currWeight <= total){
            res += process(arr , index + 1 , total - currWeight);
        }

        return res;
    }





    public static int sankBag1(int[] arr , int w){
        int N = arr.length;
        int[][] dp = new int[N][w + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return process1(arr , 0 , w , dp);
    }


    // arr 为零食数组，index为当前位置 restW 为背包剩余容量
    // 返回共有多少中零食放法
    public static int process1(int[] arr , int index , int total , int[][] dp){
        if(total == 0){
            dp[index][total] = 1;
            return 1;
        }else if(total < 0){
            return 0;
        }

        if(index >= arr.length){
            return 1;
        }

        if(dp[index][total] != -1){
            return dp[index][total];
        }

        //可以选择要或者是不要

        // a. 不要当前位置
        int res = process1(arr , index + 1 , total , dp);

        // 当前位置的体积大于剩余体积，那就只能不要当前位置
        // b.要当前位置
        int currWeight = arr[index];
        if(currWeight <= total){
            res += process1(arr , index + 1 , total - currWeight , dp);
        }
        dp[index][total] = res;
        return res;
    }




    public static int sankBag2(int[] arr , int w){
        int N = arr.length;
        int[][] dp = new int[N][w + 1];
        for(int i = 0 ; i < N ; i++){
            dp[i][0] = 1;
        }
        //只能选v[0]这一种零食的时候.判断容量是否够放这种零食如果够的话方法数为2不够的话为1
        for(int i = 0 ; i <= w ; i++){
            dp[0][i] = arr[0] <= i ? 2 : 1;
        }


        for(int i = 1 ; i < N ; i++){
            for(int j = 0 ; j <= w ; j++){
                if(arr[i] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j - arr[i]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[arr.length - 1][w];
    }




    public static void main(String[] args) {

        int[] arr = {1 ,2 ,4};
        int w = 10;

        // 8
        System.out.println(sankBag(arr , w));
        System.out.println(sankBag1(arr , w));
        System.out.println(sankBag2(arr , w));


    }






}
