package com.song.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhihong Song on 2021/3/20 10:42
 */

public class _54 {


    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素
     */


    public List<Integer> spiraOrder(int[][] matrix){
            List<Integer> order = new ArrayList<>();
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
                return order;
            }
            int rows = matrix.length;
            int columns = matrix[0].length;
            int totals = rows * columns;
            int row = 0;
            int column = 0;
            boolean[][] visited = new boolean[rows][columns];
            int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
            int directIndex = 0;
            for (int i = 0; i < totals; i++) {
                order.add(matrix[row][column]);
                visited[row][column] = true;
                int nextRow = row + directions[directIndex][0];
                int nextColumn = column + directions[directIndex][1];
                if(nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]){
                    directIndex = (directIndex + 1) % 4;
                }
                row += directions[directIndex][0];
                column += directions[directIndex][1];
            }
            return order;
    }






    public static void main(String[] args){

       int[][]  matrix ={{1,2,3},{4,5,6},{7,8,9}};
        _54 obj = new _54();
//        obj.spiraOrder(matrix).forEach(System.out::println);

        int n = 5;
        String s = Integer.toBinaryString(n);
        System.out.println(s);

    }

}
