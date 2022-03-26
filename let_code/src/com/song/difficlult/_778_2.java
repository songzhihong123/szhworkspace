package com.song.difficlult;

/**
 * Created by Zhihong Song on 2021/2/2 16:15
 */

public class _778_2 {


    private int N;

    private static final int[][] DIRECTIONS = {{0,1},{0,-1},{1,0},{-1,0}};

    public int swimInWater(int[][] grid) {
        this.N = grid .length;
        int left = 0 ;
        int right = N * N - 1;
        while(left < right){
            int mid = (left + right) / 2;
            boolean[][] visited = new boolean[N][N];
            if(grid[0][0] <= mid && dfs(grid,0 , 0, visited , mid)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     *  使用深度优先遍历得到从(x,y) 开始向四个方向的所有小于threshold 且与 (x,y) 连通的结点
     * @param grid
     * @param x
     * @param y
     * @param visited
     * @param threshold
     * @return
     */
    private boolean dfs(int[][] grid , int x , int y , boolean[][] visited , int threshold){
        visited[x][y] = true;
        for (int[] direction : DIRECTIONS) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if(isArea(newX , newY) && !visited[newX][newY] && grid[newX][newY] <= threshold){
                if(newX == N - 1 && newY == N - 1){
                    return true;
                }
                if(dfs(grid, newX, newY, visited, threshold)){
                    return true;
                }
            }
        }


        return false;
    }

    private boolean isArea(int x , int y){
        return x >= 0 && x < N && y >=0 && y < N;
    }

    public static void main(String[] args){
        _778_2 obj = new _778_2();
        int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        System.out.println(obj.swimInWater(grid));
    }



}
