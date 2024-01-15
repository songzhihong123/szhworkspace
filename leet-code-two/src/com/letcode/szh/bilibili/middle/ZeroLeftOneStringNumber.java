package com.letcode.szh.bilibili.middle;

/**
 * @ClassName ZeroLeftOneStringNumber
 * @Description ZeroLeftOneStringNumber
 * @Author szh
 * @Date 2024年01月13日
 */
public class ZeroLeftOneStringNumber {



















    // 斐波那契数列
    public static int fi(int n){
        if(n < 1){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }

        int[][] base = {
                {1 , 1},
                {1 , 0}
        };

        //  求一个矩阵的 n-2 次方
        int[][] res = matrixPower(base , n - 2);

        return res[0][0] + res[0][1];
    }


    // 求一个矩阵的p次方
    public static int[][] matrixPower(int[][] m , int p){
        int[][] res = new int[m.length][m[0].length];
        for(int i = 0 ; i < res.length ; i++){
            res[i][i] = 1;
        }

        int[][] t = m;
        for(; p != 0 ; p >>= 1){
            if((p & 1) != 0){
                res = muliMatrix(res , t);
            }
            t = muliMatrix(t , t);
        }

        return res;
    }


    // 求两个矩阵的乘法
    public static int[][] muliMatrix(int[][] m1 , int[][] m2){
        int[][] res = new int[m1.length][m2[0].length];

        for(int i = 0; i < m1.length ; i++){
            for(int j = 0 ; j< m2[0].length ; j ++){
                for(int k = 0 ; k < m2.length ; k++){
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fi(2));


        int[][] m1 = {
                {1 , 2},
                {3 , 4}
        };

        int[][] m2 = {
                {5 , 6},
                {7 , 8}
        };

        int[][] m3 = muliMatrix(m1 , m2);

        System.out.println(m3);

    }



}
