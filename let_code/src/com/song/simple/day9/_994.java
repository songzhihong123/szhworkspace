package com.song.simple.day9;

import java.util.LinkedList;
import java.util.Queue;

public class _994 {

    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};


    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int niceCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i , j});
                }else if(grid[i][j] == 1){
                    niceCount ++;
                }
            }
        }

        if(niceCount == 0){
            return 0;
        }

        int ans = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                for (int i = 0; i < 4; i++) {
                    int dmx = x + dx[i];
                    int dmy = y + dy[i];
                    if(dmx >=0 && dmx < m && dmy >=0 && dmy < n && grid[dmx][dmy] == 1){
                        grid[dmx][dmy] = 2;
                        queue.offer(new int[]{dmx , dmy});
                        niceCount --;
                    }
                }
            }
            ans ++;
        }
        return niceCount != 0 ? -1 : ans - 1;
    }


    public static void main(String[] args){

        _994 obj = new _994();
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(obj.orangesRotting(grid));
    }





}
