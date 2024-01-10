package com.letcode.szh.bilibili;

/**
 * @ClassName CoinsMin
 * @Description CoinsMin
 * @Author szh
 * @Date 2024年01月09日
 */
public class CoinsMin {



    /*

    给定一个正数数组 ， 每一个值表示一枚硬币,
    给定一个值，求组成这个值最少用多少硬币？

    例子：arr = [2 , 7 ,3, 5 ,4] , aim = 10


     */


    public static int minCoinsMin1(int[] arr , int rest){
        return process1(arr , 0 , rest);
    }



    // arr 硬币都在其中，固定参数
    // 如果自由选择arr[index..]这些硬币， 但是之前的硬币已经拥有了pre这么钱
   // aim：最终要达成的目标，固定参数
    // 最后组成aim的最少硬币数量
    public static int process1(int[] arr , int index , int rest){
        if(rest < 0){
            return -1;
        }
        if(rest == 0){
            return 0;
        }
        // rest > 0
        if(index == arr.length){
            return -1;
        }

        // rest > 0 并且有硬币
        //可以要也可以不要

        int yao = process1(arr , index + 1 , rest - arr[index]);
        int buyao = process1(arr , index + 1 , rest);

        if(buyao ==  -1 && yao == -1){
            return -1;
        }else{
            if(buyao == -1){
                return yao + 1;
            }
            if(yao == -1){
                return buyao;
            }
            return Math.min(yao + 1   , buyao);
        }

    }


    public static int minCoinsMin2(int[] arr , int rest){
        int[][] dp = new int[arr.length + 1][rest + 1];

        for(int i = 0 ; i <= arr.length ; i ++){
            for(int j= 0 ;i <= rest ; i++){
                dp[i][j] = -2;
            }
        }

        return process2(arr , 0 , rest , dp);
    }



    // arr[index...] 组成出rest这么多钱，最少的硬币数量返回
    public static int process2(int[] arr , int index , int rest , int[][] dp){
        if(rest < 0){
            return -1;
        }

        if(dp[index][rest] != -2){
            return dp[index][rest];
        }
        if(rest == 0){
            dp[index][rest] = 0;
            return dp[index][rest];
        }
        // rest > 0
        if(index == arr.length){
            dp[index][rest] = -1;
            return dp[index][rest];
        }

        // rest > 0 并且有硬币
        //可以要也可以不要

        int yao = process2(arr , index + 1 , rest - arr[index] , dp);
        int buyao = process2(arr , index + 1 , rest , dp);

        if(buyao ==  -1 && yao == -1){
            dp[index][rest] = -1;
        }else{
            if(buyao == -1){
                dp[index][rest] = yao + 1;
            }else if(yao == -1){
                dp[index][rest] = buyao;
            }else{
                dp[index][rest] = Math.min(yao + 1   , buyao);
            }
        }

        return dp[index][rest];
    }





    // 动态规划
    public static int minCoinsMin3(int[] arr , int aim){
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];

        for(int row = 0 ; row <= N ; row ++){
            dp[row][0] = 0;
        }
        for(int col = 1 ; col <= aim ; col ++){
            dp[N][col] = -1;
        }
        for(int index = N - 1 ; index >= 0 ; index --){
            for(int rest = 1 ; rest <= aim; rest ++){
                int buyao = dp[index + 1][rest];
                int yao = -1;
                if(rest - arr[index] >= 0){
                    yao = dp[index - 1][rest - arr[index]];
                }

                if(buyao ==  -1 && yao == -1){
                    dp[index][rest] = -1;
                }else{
                    if(buyao == -1){
                        dp[index][rest] = -yao + 1;
                    }else if(yao == -1){
                        dp[index][rest] =  buyao;
                    }else{
                        dp[index][rest] =  Math.min(yao + 1   , buyao);
                    }
                }
            }
        }
        return dp[0][aim];
    }







}
