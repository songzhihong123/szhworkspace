package com.letcode.szh.bilibili;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @ClassName BobDie
 * @Description BobDie
 * @Author szh
 * @Date 2024年01月10日
 */
public class BobDie {


    /*
    在一个N * M 的格子中 ， Bob当前位置是 （x， y），
    求Bob 走了 k 步之后，还可以生存下来的几率是多少？
    Bob 只能走上下左右，四个方向走，不允许走斜线

    生存下来的方法数 / 总次数

    总次数是 4 ^ k , 每个点都可以上下左右四种走法

     */
    public static String bob1(int N , int M , int x , int y , int k){
        long all = (long)Math.pow(4 , k);
        long live = process(N , M , x ,y , k);
        return new BigDecimal(live).divide(new BigDecimal(all) , RoundingMode.HALF_UP).toPlainString();
    }




    // 在一个N * M 的格子中， 当前位置是 （row , col），走rest 步 不越界的个数
    // 获得生存总数
    public static int process(int N , int M , int row , int col , int rest){
        if(row < 0 || row >= N || col < 0 || col >= M){
            return 0;
        }
        if(rest == 0){
            return 1;
        }

        int count = process(N , M , row + 1 , col , rest - 1) ;
        count += process(N , M , row - 1 , col , rest - 1) ;
        count += process(N , M , row, col + 1, rest - 1) ;
        count += process(N , M , row , col - 1, rest - 1) ;

        return count;
    }




    public static String bob2(int N , int M , int x , int y , int K){

        int[][][] dp = new int[N + 2][M + 2][K + 1];

        for(int row = 1 ; row <= N ; row ++){
            for(int col = 1 ; col<= M ; col ++){
                dp[row][col][0] = 1;
            }
        }

        for(int h = 1 ; h <= K ; h++){ // 层数
            for(int r = 1 ; r <= N ; r ++){
                for(int c = 1 ; c <= M ; c ++){
                    dp[r][c][h] = dp[r + 1][c][h - 1];
                    dp[r][c][h] += dp[r - 1][c][h - 1];
                    dp[r][c][h] += dp[r][c + 1][h - 1];
                    dp[r][c][h] += dp[r][c - 1][h - 1];
                }
            }
        }

//        long all = (long)Math.pow(4 , K);
//        long live = dp[x][y][K];
//        return new BigDecimal(live).divide(new BigDecimal(all) , RoundingMode.HALF_UP).toPlainString();

        return String.valueOf(dp[x + 1][y + 1][K]);
    }





    public static void main(String[] args) {

        int N = 5;
        int M = 5;
        int x = 1;
        int y =  2;
        int K = 10;

        System.out.println(process(N , M , x , y , K));
        System.out.println(bob2(N , M , x , y , K));


    }


}
