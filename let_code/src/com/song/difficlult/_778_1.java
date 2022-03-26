package com.song.difficlult;

import java.util.Arrays;

/**
 * Created by Zhihong Song on 2021/2/2 15:43
 */

public class _778_1 {

    private int N;

    private static final int[][] DIRECTIONS = {{0,1},{0,-1},{1,0},{-1,0}};


    public int swimInWater(int[][] grid) {
        this.N = grid.length;
        int len = N * N ;
        int[] array = new int[len];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[grid[i][j]] = getIndex(i,j);
            }
        }

        UnionFind unionFind = new UnionFind(len);
        for (int i = 0; i < len; i++) {
            int x = array[i] / N;
            int y = array[i] % N;
            for (int [] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if(isArea(newX,newY) && grid[newX][newY] <= i){
                    unionFind.union(array[i],getIndex(newX,newY));
                }
                if(unionFind.isConnected(0,len - 1)){
                    return i;
                }
            }
        }
        return -1;
    }

    private int getIndex(int i , int j){
        return i * N + j;
    }

    private boolean isArea(int x , int y){
        return x >= 0 && x < N && y >=0 && y < N;
    }

    private class UnionFind{
        int[] parent;
        int[] rank;
        int setCount;
        int n ;

        public UnionFind(int size){
            this . n = size;
            this.setCount = size;
            parent = new int[size];
            rank = new int[size];
            Arrays.fill(rank,1);
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int getSize(){
            return parent.length;
        }

        public int find(int p){
            while (parent[p] != p){
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public boolean isConnected(int p , int q){
            return find(p) == find(q);
        }

        public boolean union(int p , int q){
            int pRoot = find(p);
            int qRoot = find(q);

            if (qRoot == pRoot){
                return false;
            }

            if(rank[pRoot] > rank[qRoot]){
                parent[qRoot] = pRoot;
            }else if(rank[qRoot] > rank[pRoot]){
                parent[pRoot] = qRoot;
            }else {//rank[qRoot] == rank[pRoot]
                parent[qRoot] = pRoot;
                rank[pRoot] += 1;
            }
            setCount -- ;
            return true;
        }

    }


    public static void main(String[] args){
        _778_1 obj = new _778_1();
        int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        System.out.println(obj.swimInWater(grid));
    }

}
