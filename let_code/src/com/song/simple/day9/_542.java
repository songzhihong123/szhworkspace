package com.song.simple.day9;


import java.util.LinkedList;
import java.util.Queue;

public class _542 {

    public int[][] updateMatrix(int[][] mat) {

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = mat.length , n = mat[0].length;

        boolean[][] marks = new boolean[m][n];
        int[][] ans = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i , j});
                    marks[i][j] = true;
                }

            }
        }

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int i = poll[0] , j = poll[1];

            for (int k = 0; k < 4; k++) {

                int dmx = i + dirs[k][0] , dmy = j + dirs[k][1];

                if(dmx >= 0 && dmx < m && dmy >=0 && dmy < n && !marks[dmx][dmy]){
                    ans[dmx][dmy] = ans[i][j] + 1;
                    queue.offer(new int[]{dmx , dmy});
                    marks[dmx][dmy] = true;

                }

            }

        }
        return ans;
    }





    public static void main(String[] args){
        _542 obj = new _542();
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] ints = obj.updateMatrix(mat);
        for(int[] in : ints){
            for(int i : in){
                System.out.print(i + " ");
            }
            System.out.println();
        }


    }




}
