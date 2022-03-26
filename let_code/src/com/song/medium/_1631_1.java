package com.song.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Zhihong Song on 2021/1/29 10:46
 */

public class _1631_1 {


    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int left = 0;
        int right = 999999;
        int ans = 0;
        while (left <= right){
            int mid = (left + right) / 2;
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0,0});
            boolean[] seen = new boolean[m * n];
            seen[0] = true;
            while (!queue.isEmpty()){
                int[] cell = queue.poll();
                int x = cell[0],y = cell[1];
                for (int i = 0; i < 4; i++) {
                    int nx = x + dirs[i][0];
                    int ny = y + dirs[i][1];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n
                        && !seen[nx * x + ny] && Math.abs(heights[x][y] - heights[nx][ny]) <= mid){
                        queue.offer(new int[]{nx,ny});
                        seen[nx * x + ny] = true;
                    }
                }
            }
            if(seen[m * n - 1]){
                ans = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        _1631_1 obj = new _1631_1();
        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(obj.minimumEffortPath(heights));
    }

}
