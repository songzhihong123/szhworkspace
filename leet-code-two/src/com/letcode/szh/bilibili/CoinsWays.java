package com.letcode.szh.bilibili;

/**
 * @ClassName CoinsWays
 * @Description CoinsWays
 * @Author szh
 * @Date 2024年01月10日
 */
public class CoinsWays {


    // arr 里面都是正数， 没有重复值， 每一个值代表一种货币， 每一种都可以饿用无限张
    // 最终要找零钱数是aim
    // 找零方法数返回
    public static int way1(int[] arr , int aim){
        return process(arr , 0 , aim);
    }

    // index 代表当前位置， rest代表剩余面值数
    // arr[index..]后面的值随便使用
    // 返回值为方法数
    public static int process(int[] arr , int index , int rest){
        if(index == arr.length){
            return rest == 0 ? 1 : 0;
        }

        int ways = 0;

        for(int zhang = 0 ; arr[index] * zhang <= rest ; zhang ++){
            ways += process(arr , index + 1 , rest - (arr[index] * zhang));
        }

        return ways;
    }



    public static int way2(int[] arr , int aim){
        if(arr == null || arr.length <= 0){
            return 0;
        }

        int N =arr.length;
        int[][] dp = new int[ N + 1 ][aim + 1];
        dp[N][0] = 1;

        for(int index = N -1 ; index >= 0 ; index --){
            for(int rest = 0 ; rest <= aim ; rest++){
                int ways = 0;
                // 出现了枚举行为
                for(int zhang = 0 ; arr[index] * zhang <= rest ; zhang ++){
                    ways += dp[index + 1] [rest - (arr[index] * zhang)];
                }
                dp[index][rest] = ways;
            }
        }

        return dp[0][aim];
    }



    public static int way3(int[] arr , int aim){
        if(arr == null || arr.length <= 0){
            return 0;
        }

        int N =arr.length;
        int[][] dp = new int[ N + 1 ][aim + 1];
        dp[N][0] = 1;

        for(int index = N -1 ; index >= 0 ; index --){
            for(int rest = 0 ; rest <= aim ; rest++){
                dp[index][rest] = dp[index + 1][rest];
                // 出现了枚举行为，观察枚举行为是不是可以用临近的格子来替代枚举行为
                // 斜率优化 ， 枚举行为被近距离格子替代的行为
                if(rest - arr[index] >= 0){
                    dp[index][rest] += dp[index][rest - arr[index]];
                }
            }
        }

        return dp[0][aim];
    }





}
