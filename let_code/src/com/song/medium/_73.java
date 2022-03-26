package com.song.medium;

/**
 * Created by Zhihong Song on 2021/3/22 16:08
 */

public class _73 {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0){
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n; j++) {
                if(row[i] || col[j]){
                    matrix[i][j] = 0;
                }
            }
        }

    }


    public void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean flagRow = false;
        boolean flagCol = false;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0){
                flagCol = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if(matrix[0][i] == 0){
                flagRow = true;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(flagRow){
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }


        if(flagCol){
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }


    }








    public static void main(String[] args){
        _73 obj = new _73();
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        obj.setZeroes1(matrix);
    }


}
