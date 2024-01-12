package com.letcode.szh.bilibili.middle;

/**
 * @ClassName IsExistAim
 * @Description IsExistAim
 * @Author szh
 * @Date 2024年01月11日
 */
public class IsExistAim {

    /*
    给定一个元素为非负数的二维数组matrix，每行和每列都是从小到大有序的。
    在给定一个非负整数aim ， 请判断aim是否在matrix中

    aim = 7
    matrix
     例如：
        1   5   9   10
        2   6   11  13
        7   9   15  17



      技巧：
        从右上角开始遍历，从右往左，从上往下
     */


    public static boolean isExistAim(int[][] matrix , int aim){
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }


        int N = matrix.length;
        int L = matrix[0].length;

        int row = 0;
        int col = L - 1;



        while(row <= N - 1 && col >= 0){
            if(matrix[row][col] == aim){
                return true;
            }else if(matrix[row][col] > aim){
                col --;
            }else{ // matrix[row][col] < aim
                row ++;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1 , 5 , 9,  10},
                {2 , 6 , 11 , 13},
                {7 , 9 , 15 , 17}
        };
        int aim = 7;

        System.out.println(isExistAim(matrix , aim));


    }





}
