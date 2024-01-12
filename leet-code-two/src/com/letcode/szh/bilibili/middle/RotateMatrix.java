package com.letcode.szh.bilibili.middle;

/**
 * @ClassName RotateMatrix
 * @Description RotateMatrix 旋转数组
 * @Author szh
 * @Date 2024年01月12日
 */
public class RotateMatrix {


    /*

    顺时针转一圈二位数组


     */

    public static void rotate(int[][] matrix){

        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix[0].length - 1;

        while(a <= c && b <= d){
            rotateEdge(matrix ,a++ , b++ , c--, d--);
        }

        System.out.println("end...");
    }






    // 旋转一个边框
    public static void rotateEdge(int[][] m , int a , int b , int c , int d){


        int temp = 0;

        // 总共需要旋转的组数是b - d 组
        // 第i组需要交换的位置分别是
        // m[a][b + i]
        // m[a + i][d]
        // m[c][d - i]
        // m[d - i][b]
        for(int i = 0 ; i < d - b ; i ++){
            temp = m[d - i][b];
            m[d - i][b] = m[c][d - i];
            m[c][d - i] = m[a + i][d];
            m[a + i][d] = m[a][b + i];
            m[a][b + i] = temp;
        }


    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10 ,11 ,12},
                {13, 14 ,15 ,16}
        };
        rotate(matrix);
    }



}
