package com.song.difficlult;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Zhihong Song on 2021/2/2 11:05
 */

public class _778 {

    private int N;

    private static final int[][] DIRECTIONS = {{0,1},{0,-1},{1,0},{-1,0}};

    public int swimInWater(int[][] grid) {
        this.N = grid.length;
        int left = 0;
        int right = N * N - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(grid[0][0] <= mid && bfs(grid,mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     *  使用广度优先遍历得到从(x,y)开始向四个方向所有小于等于threshold且与(x,y)连通的节点。
     * @param grid
     * @param threshold
     * @return
     */
    private boolean bfs(int[][] grid,int threshold){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int[] front = queue.poll();
            int x = front[0];
            int y = front[1];
            for(int[] direction : DIRECTIONS){
                int newX = x + direction[0];
                int newY = y + direction[1];
                if(isArea(newX,newY) && !visited[newX][newY] && grid[newX][newY] <= threshold){
                    if(newX == N - 1 && newY == N - 1){
                        return true;
                    }
                    queue.offer(new int[]{newX,newY});
                    visited[newX][newY] = true;
                }
            }

        }
        return false;
    }

    private boolean isArea(int x , int y){
        return x >=0 && x < N && y >=0  && y < N;
    }



    public static void main(String[] args){
        _778 obj = new _778();
        int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        System.out.println(obj.swimInWater(grid));
    }


}
