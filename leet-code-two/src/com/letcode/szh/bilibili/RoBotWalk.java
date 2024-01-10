package com.letcode.szh.bilibili;

/**
 * @ClassName RoBotWalk
 * @Description RoBotWalk
 * @Author szh
 * @Date 2024年01月09日
 */
public class RoBotWalk {

    /*

    给一个值N， 表示 1 ～ N 这个范围的数
    给一个值E ，表示从值E出发
    给一个值S， 表示目的地是S
    给一个值K ， 表示最多走K步

    可以向前走，也可以向后走，求有多少中走法？


     */


    public static int walkWays1(int N , int E , int S , int K){
        return f(N , E , K , S);
    }



    // 1、一共有1～N这么多个数
    // 2、最终目标是E
    // 3、rest表示还剩下多少步
    // 4、cur表示当前的位置

    // 来到 cur 位置，可以向前走，也可以向后走
    // cur在第一个位置，只能向前走
    // cur在最后一个位置，只能向前走
    public static int f(int N , int E , int rest , int cur){
        if(rest == 0){
            return cur == E ? 1 : 0;
        }
        // rest > 0 还有路可以走
        if(cur == 1){ // 1 -> 2
            return f(N , E , rest - 1 , 2);
        }
        if(cur == N){
            return f(N , E , rest - 1 , N - 1);
        }

        return f(N , E , rest - 1 , cur - 1) + f(N , E , rest - 1 , cur + 1);
    }


    public static int walkWays2(int N , int E , int S , int K){
        int[][] dp = new int[K + 1][N + 1];
        for(int i = 0 ; i <=K ; i++){
            for(int j = 0 ; j<= S  ; j++){
                dp[i][j] = -1;
            }
        }
        return f1(N , E , K , S , dp);
    }


    // 1、一共有1～N这么多个数
    // 2、最终目标是E
    // 3、rest表示还剩下多少步
    // 4、cur表示当前位置
    public static int f1(int N , int E , int rest , int cur , int[][] dp){
        if(dp[rest][cur] != -1){
            return dp[rest][cur];
        }
        // 缓存每命中
        if(rest == 0){
            dp[rest][cur] = cur == E ? 1 : 0;
            return dp[rest][cur];
        }
        // rest > 0 还有路可以走
        if(cur == 1){ // 1 -> 2
            dp[rest][cur] = f1(N , E , rest - 1 , 2 , dp);
        }else if(cur == N){
            dp[rest][cur] = f1(N , E , rest - 1 , N - 1 , dp);
        }else {
            dp[rest][cur] = f1(N , E , rest - 1 , cur - 1, dp) + f1(N , E , rest - 1 , cur + 1, dp);
        }
        return dp[rest][cur];
    }

















}
