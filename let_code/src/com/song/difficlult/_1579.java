package com.song.difficlult;

import java.util.Arrays;

/**
 * Created by Zhihong Song on 2021/1/27 9:01
 */

public class _1579 {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        if(edges.length == 0){
            return -1;
        }
        int res = 0;

        UnionFind unionFind1A3 = new UnionFind(n + 1);
        UnionFind unionFind2A3 = new UnionFind(n + 1);
        //1. 先把type=3 的边连起来
        for (int[] edge : edges) {
            if(edge[0] == 3){
                if(!unionFind1A3.union(edge[1],edge[2])){
                    res ++;
                }else {
                    unionFind2A3.union(edge[1],edge[2]);
                }
            }
        }
        //2. 把type=1 的和 type=3 的先组合起来
        for (int[] edge : edges) {
            if(edge[0] == 1){
                if(!unionFind1A3.union(edge[1],edge[2])){
                    res ++;
                }
            }
        }
        if(unionFind1A3.shellCount != 2){
            return -1;
        }
        //3. 把type=2 的和 type=3 的先组合起来
        for (int[] edge : edges) {
            if(edge[0] == 2){
                if(!unionFind2A3.union(edge[1],edge[2])){
                    res ++;
                }
            }
        }
        if(unionFind2A3.shellCount != 2){
            return -1;
        }
        return res;
    }

    private class UnionFind{
        int[] parent;
        int[] rank;
        int size;
        int shellCount;

        public UnionFind(int size){
            this.size = size;
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
            while (p != parent[p]){
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public boolean isConncted(int p , int q){
            return find(p) == find(q);
        }

        public boolean union(int p , int q){
            int qRoot = find(q);
            int pRoot = find(p);
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
            shellCount --;
            return true;
        }

    }





    public static void main(String[] args){
        _1579 obj = new _1579();
//        int[][] edges = {{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};
//        int n = 4;

//        int[][] edges = {{3,1,2},{3,2,3},{1,1,4},{2,1,4}};
//        int n = 4;

        int[][] edges = {{3,2,3},{1,1,2},{2,3,4}};
        int n = 4;
        System.out.println(obj.maxNumEdgesToRemove(n, edges));
    }

}
