package com.letcode.szh.bilibili.middle;

import com.sun.corba.se.spi.orbutil.fsm.FSM;

/**
 * @ClassName ZigZagPrintMatrix
 * @Description ZigZagPrintMatrix
 * @Author szh
 * @Date 2024年01月12日
 */
public class ZigZagPrintMatrix {


    /*

    用zigzag的方式打印矩阵 ，

    0 1 2  3
    4 5 6  7
    8 9 10 11

    0  1 3 8 5 2 3 6 9 10 7 11

     */

    public static void printMatrixAigZag(int[][] matrix){
        int ar = 0;
        int ac = 0;
        int br = 0;
        int bc = 0;

        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = true;

        while(ar != endR + 1){
            printLevel(matrix , ar , ac , br , bc , fromUp);
            ar = ac == endC ? ar + 1 : ar;
            ac = ac == endC ? ac : ac  + 1 ;
            bc = br == endR ? bc + 1 : bc;
            br = br == endR ? br : br + 1;
            fromUp = !fromUp;
        }

    }


    public static void printLevel(int[][] m , int tR , int tC , int dR , int dC , boolean f){

        if(f){ // f为true 从左下方往右上方打印
            while(dC != tC + 1){
                System.out.println(m[dR--][dC++] + " ");
            }
        }else{ // f为true 从右上方往左下方打印
            while(dR != tR - 1){
                System.out.println(m[tR++][tC--] + " ");
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 1, 2, 3},
                {4 ,5, 6, 7,},
                {8, 9, 10 ,11}
        };

        printMatrixAigZag(matrix);
    }




}
