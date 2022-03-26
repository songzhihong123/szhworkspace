package com.song.difficlult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Zhihong Song on 2021/1/21 8:47
 */

public class _1489 {

    /**
     * 关键边：如果最小生成树中删去某条边，会导致最小生成树的权值和增加，那么我们就说它是一条关键边。
     *          也就是说，如果设原图最小生成树的权值为 value ，那么去掉这条边后：
     *
     *     要么整个图不连通，不存在最小生成树；
     *     要么整个图联通，对应的最小生成树的权值为 v，其严格大于 value。
     *
     * 伪关键边：可能会出现在某些最小生成树中但不会出现在所有最小生成树中的边。
     *      也就是说，我们可以在计算最小生成树的过程中，最先考虑这条边，即最先将这条边的两个端点在并查集中合并。
     *      设最终得到的最小生成树权值为 v，如果 v=value ，那么这条边就是伪关键边。
     *
     */


    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {

        int len = edges.length;
        List<Edge> edgesList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            edgesList.add(new Edge(i,edges[i][0],edges[i][1],edges[i][2]));
        }
        Collections.sort(edgesList,(a,b) -> a.weight - b.weight);

        UnionFind unionFind = new UnionFind(n);
        // 生成最小生成树,并且算出最小生成树的权值
        int size = edgesList.size();
        int value = 0;
        for (int i = 0; i < size; i++) {
            if (unionFind.union(edgesList.get(i).start,edgesList.get(i).end)){
                value += edgesList.get(i).weight;
            }
        }
        List<List<Integer>> resultList = new ArrayList<>();
        resultList.add(new ArrayList<>());
        resultList.add(new ArrayList<>());
        for (int i = 0; i < size; i++) {
            //判断是否是关建边
            UnionFind tempFind = new UnionFind(n);
            int tempvalue = 0;
            for (int j = 0; j < size; j++) {
                if(i != j && tempFind.union(edgesList.get(j).start,edgesList.get(j).end)){
                    tempvalue += edgesList.get(j).weight;
                }
            }
            // setCount 初始为 节点个数，连通一次减一，全部连通的时候 setCount 的值为1
            if (tempFind.setCount != 1 || (tempFind.setCount == 1 && tempvalue > value)) {
                resultList.get(0).add(edgesList.get(i).index);
                continue;
            }

            // 判断是否是伪关建边
            tempFind = new UnionFind(n);
            tempFind.union(edgesList.get(i).start,edgesList.get(i).end);
            tempvalue = edgesList.get(i).weight;
            for (int j = 0; j < size; j++) {
                if(i != j && tempFind.union(edgesList.get(j).start,edgesList.get(j).end)){
                    tempvalue += edgesList.get(j).weight;
                }
            }
            if(tempvalue == value){
                resultList.get(1).add(edgesList.get(i).index);
            }

        }
        return resultList;
    }


    private class Edge{
        public int index;
        public int start;
        public int end;
        public int weight;

        public Edge(int index, int start, int end, int weight) {
            this.index = index;
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    private class UnionFind{
        int[] parent;
        int[] rank;
        // 当前连通分量的数目，可以用来判断size节点之间是否全部连通
        int setCount;

        public UnionFind(int size){
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

            if (pRoot == qRoot){
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


    public static void main(String[] args) {
        _1489 obj = new _1489();
        int n = 5;
        int[][] edges = {{0,1,1},{1,2,1},{2,3,2},{0,3,2},{0,4,3},{3,4,3},{1,4,6}};
//        int n = 4;
//        int[][] edges =  {{0,1,1},{1,2,1},{2,3,1},{0,3,1}};
        List<List<Integer>> resList = obj.findCriticalAndPseudoCriticalEdges(n, edges);
        System.out.println(resList);

    }

}
