package com.letcode.szh.bilibili;

/**
 * @ClassName Islands
 * @Description 岛问题
 * @Author szh
 * @Date 2024年01月07日
 */
public class Islands {

    /*

       一个矩阵中只有0和1两种值，每个位置都可以和自己的上下左右四个位置相连，
       如果有一片1连在一起，这个部分叫做一个岛，求一个矩阵中有多少个岛？

     */

    public static int countIslands(int[][] m){
        if(m == null || m[0] == null){
            return 0;
        }
        int M = m.length;
        int N = m[0].length;

        int res = 0;
        for(int i = 0 ; i < M ;i ++){
            for(int j= 0 ; j < N ; j++){
                if(m[i][j] == 1){
                    res ++;
                    infect(m , i , j , M , N);
                }
            }
        }


        return res;
    }


    // 在矩阵m中，（i， j）位置开始进行感染，把上下左右位置的数都改成2
    public static void infect(int[][] m , int i , int j , int M , int N){
        if(i < 0 || i >=M || j < 0 || j>= N || m[i][j] != 1){
            return;
        }
        m[i][j] = 2;
        infect(m , i , j - 1 , M , N);
        infect(m , i , j + 1 , M , N);
        infect(m , i - 1, j , M , N);
        infect(m , i + 1, j , M , N);
    }



}
