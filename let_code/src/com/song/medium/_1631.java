package com.song.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Zhihong Song on 2021/1/29 8:50
 */

public class _1631 {

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<Edges> edges = new ArrayList<>();
        // 1. 构造 edges 数据
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // id 表示每个格子的下标
                int id = i * n + j;
                // 策略：当前节点可以与上一个和前一个相结合
                //1）.与前一个
                if(j > 0){
                    edges.add(new Edges(id-1 , id , Math.abs(heights[i][j] - heights[i][j - 1])));
                }
                // 2). 与上一个
                if(i > 0){
                    edges.add(new Edges(id - n , id , Math.abs(heights[i][j] - heights[i - 1][j])));
                }
            }
        }
        //排序.
        Collections.sort(edges,(e1,e2) -> e1.weight - e2.weight);

        UnionFind unionFind = new UnionFind(m * n);
        int res = 0;
        for (Edges edge : edges) {
            int start = edge.start;
            int end = edge.end;
            int weight =edge.weight;
            unionFind.union(start,end);
            if(unionFind.isConn(0,n * m - 1)){
                res = weight;
                break;
            }
        }
        return res;
    }


    private class Edges{
        public int start;
        public int end;
        public int weight;

        public Edges(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    private class UnionFind{
        private int[] parent;
        private int[] rank;

        public UnionFind(int size){
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
            while(p != parent[p]){
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public boolean isConn(int p , int q){
            return find(p) == find(q);
        }

        public boolean union(int p , int q){
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot){
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
            return true;
        }


    }


    public static void main(String[] args){
        _1631 obj = new _1631();
        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(obj.minimumEffortPath(heights));
    }


}
