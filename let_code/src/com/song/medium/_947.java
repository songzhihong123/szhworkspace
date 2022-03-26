package com.song.medium;

import java.util.Arrays;

/**
 * Created by Zhihong Song on 2021/1/26 11:12
 */

public class _947 {

    public int removeStones(int[][] stones) {
        int len = stones.length;
        if(len <= 1){
            return 0;
        }
        UnionFind unionFind = new UnionFind(len);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    unionFind.union(i,j);
                }
            }
        }
        return len - unionFind.sellCount;
    }

    private class UnionFind{
        int[] parent;
        int[] rank;
        int size;
        int sellCount;

        public UnionFind(int size){
            this.size = size;
            sellCount = size;
            parent = new int[size];
            rank = new int[size];
            Arrays.fill(rank,1);
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int getSize(){
            return  parent.length;
        }

        public int find(int p){
            while (parent[p] != p){
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public boolean isConnented(int p ,int q){
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
            }else if(rank[pRoot] < rank[qRoot]){
                parent[pRoot] = qRoot;
            }else{
                parent[pRoot] = qRoot;
                rank[qRoot] = pRoot;
            }
            sellCount--;
            return true;
        }
    }


    public static void main(String[] args){
        _947 obj = new _947();
        int[][] stones =  {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        System.out.println(obj.removeStones(stones));
    }



}
