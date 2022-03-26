package com.song.simple.day7;

import java.util.LinkedList;
import java.util.Queue;

public class _733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0 , -1};

        int currColor = image[sr][sc];
        if(currColor == newColor){
            return image;
        }
        int n = image.length , m = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr ,sc});
        image[sr][sc] = newColor;
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if(mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor){
                    queue.offer(new int[]{mx , my});
                    image[mx][my] = newColor;
                }
            }
        }
        return image;
    }



    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};


    public int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {

        int currentColor = image[sr][sc];
        if(newColor != currentColor){
            dfs(image , sr ,sc , newColor , currentColor);
        }

        return image;
    }

    public void dfs(int[][] images , int x , int y , int newColor , int currentColor){
        if (currentColor == images[x][y]){
            images[x][y] = newColor;
            for (int i = 0; i < 4; i++) {
                int dmx = x + dx[i];
                int dmy = y + dy[i];
                if(dmx >= 0 && dmx < images.length && dmy >= 0 && dmy < images[0].length){
                    dfs(images , dmx , dmy , newColor , currentColor);
                }

            }
        }
    }



    public static void main(String[] args){
        _733 obj = new _733();
        int[][] image = {{1,1,1},{1,1,0},{2,0,1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        int[][] ints = obj.floodFill1(image, sr, sc, newColor);

        for (int[] in : ints){
            for(int i : in){
                System.out.print(i + " ");
            }
        }
    }




}
