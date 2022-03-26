package com.song.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Zhihong Song on 2021/1/23 10:29
 */

public class _1319 {

    public int makeConnected(int n, int[][] connections) {

        if(connections.length < n - 1){
            return -1;
        }

        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < connections.length; i++) {
            int[] partConn = connections[i];
            unionFind.union(partConn[0],partConn[1]);
        }

        return unionFind.sellCount - 1;
    }

    private class UnionFind{
        int[] parent;
        int[] rank;

        int sellCount;

        public UnionFind(int size){
            sellCount = size;
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

        public int find(int i){
            while (parent[i] != i){
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
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
            }else if(rank[pRoot] < rank[qRoot]){
                parent[pRoot] = qRoot;
            }else{
                parent[pRoot] = qRoot;
                rank[qRoot] += 1;
            }
            sellCount --;
            return true;
        }
    }

    public static void main(String[] args){
        _1319 obj = new _1319();
//        int n = 4;
//        int[][] connections = {{0,1},{0,2},{1,2}};

//        int n = 6;
//        int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};

        int n = 6;
        int[][] connections = {{0,1},{0,2},{0,3},{1,2}};

//        int n = 5;
//        int[][] connections = {{0,1},{0,2},{3,4},{2,3}};
        System.out.println(obj.makeConnected(n, connections));
    }

}
