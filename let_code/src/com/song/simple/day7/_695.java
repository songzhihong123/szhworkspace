package com.song.simple.day7;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class _695 {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};


    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = Math.max(dfs(grid, i ,j) , ans);
            }
        }
        return ans;
    }


    public int dfs(int[][] grid , int x , int y){
        if(x < 0 || y < 0 || x == grid.length || y == grid[0].length || grid[x][y] != 1){
            return 0;
        }
        grid[x][y] = 0;
        int ans = 1;
        for (int i = 0; i < 4; i++) {
            int dmx = x + dx[i];
            int dmy = y + dy[i];
            ans += dfs(grid , dmx , dmy);
        }
        return ans;
    }


    public int maxAreaOfIsland1(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int cur = 0;
                Deque<Integer> stacki = new LinkedList<>();
                Deque<Integer> stackj = new LinkedList<>();
                stacki.push(i);
                stackj.push(j);
                while(!stacki.isEmpty()){
                    int cur_i = stacki.pop();
                    int cur_j = stackj.pop();
                    if(cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] != 1){
                        continue;
                    }
                    cur ++;
                    grid[cur_i][cur_j] = 0;
                    for (int k = 0; k < 4; k++) {
                        int dmx = cur_i + dx[k];
                        int dmy = cur_j + dy[k];
                        stacki.push(dmx);
                        stackj.push(dmy);
                    }
                }
                ans = Math.max(ans , cur);
            }
        }
        return ans;
    }

    public int maxAreaOfIsland2(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int cur = 0;
                Queue<Integer> queuei = new LinkedList<Integer>();
                Queue<Integer> queuej = new LinkedList<Integer>();

                queuei.offer(i);
                queuej.offer(j);
                while(!queuei.isEmpty()){
                    int cur_i = queuei.poll();
                    int cur_j = queuej.poll();
                    if(cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] != 1){
                        continue;
                    }
                    cur ++;
                    grid[cur_i][cur_j] = 0;
                    for (int k = 0; k < 4; k++) {
                        int dmx = cur_i + dx[k];
                        int dmy = cur_j + dy[k];
                        queuei.offer(dmx);
                        queuej.offer(dmy);
                    }
                }
                ans = Math.max(ans , cur);
            }
        }
        return ans;
    }



    public int maxAreaOfIsland3(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int temp = 0;
                queue.offer(new int[]{i ,j});
                while (!queue.isEmpty()){
                    int[] poll = queue.poll();
                    int dmi = poll[0];
                    int dmj = poll[1];
                    if (dmi < 0 || dmj < 0 || dmi == grid.length || dmj == grid[0].length || grid[dmi][dmj] != 1) {
                        continue;
                    }
                    temp++;
                    grid[dmi][dmj] = 0;
                    for (int k = 0; k < 4; k++) {
                        int dmx = dmi + dx[k];
                        int dmy = dmj + dy[k];
                        if(dmx >= 0 && dmx < n && dmy >=0 && dmy < m && grid[dmx][dmy] == 1){
                            queue.offer(new int[]{dmx , dmy});
                        }
                    }
                }
                ans = Math.max(ans , temp);
            }
            
        }

        return ans;
    }








    public static void main(String[] args){




    }


}
