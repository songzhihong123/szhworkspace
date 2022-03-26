package com.song.medium;

import java.util.Arrays;

/**
 * Created by Zhihong Song on 2021/1/25 21:29
 */

public class _959 {


    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        int size = 4 * N * N;
        UnionFind unionFind = new UnionFind(size);

        for (int i = 0; i < N; i++) {
            char[] charArray = grid[i].toCharArray();
            for (int j = 0; j < N; j++) {
                // index 表示每个小格子 0 坐标表示的空格 在 一整个大格子对应的下标
                int index = 4 * (i * N + j);
                char arr = charArray[j];
                if(arr == '/'){
                    unionFind.union(index,index + 3);
                    unionFind.union(index + 1 , index + 2);
                }else if(arr == '\\'){
                    unionFind.union(index,index + 1);
                    unionFind.union(index+ 2 , index + 3);
                }else {
                    unionFind.union(index , index + 1);
                    unionFind.union(index + 1 , index + 2);
                    unionFind.union(index + 2 , index + 3);
                }
                // 向右
                if(j + 1 < N){
                    unionFind.union(index + 1 , 4 * (i * N + j + 1) + 3);
                }
                //向下
                if(i + 1 < N){
                   unionFind.union(index + 2 , 4 * ((i + 1) * N + j));
                }
            }
        }
        return unionFind.shellCount;
    }


    private class UnionFind{
        int[] parent;
        int[] rank;
        int shellCount;

        public UnionFind(int size){
            this.shellCount = size;
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
            while(parent[p] != p){
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
            if(pRoot == qRoot){
                return false;
            }
            if(rank[pRoot] > rank[qRoot]){
                parent[qRoot] = pRoot;
            }else if(rank[qRoot] > rank[pRoot]){
                parent[pRoot] = qRoot;
            }else{ // rank[qRoot] == rank[pRoot]
                parent[pRoot] = qRoot;
                rank[qRoot] += 1;
            }
            shellCount --;
            return true;
        }
    }

    public static void main(String[] args){
        _959 obj  = new _959();
        String[] grid = {" /","  "};
        System.out.println(obj.regionsBySlashes(grid));

    }


}
