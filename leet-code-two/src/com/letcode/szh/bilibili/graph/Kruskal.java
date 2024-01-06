package com.letcode.szh.bilibili.graph;

import java.util.*;

/**
 * @ClassName Kruskal
 * @Description Kruskal 算法生成最小生成树 要求无向图
 * @Author szh
 * @Date 2024年01月05日
 */
public class Kruskal {


    // 定义一个并查集
    public static class UnionFind{

        public int[] parent;// parent[i] 表示父亲当前节点的父亲节点

        public int[] rank; // rank[i] 表示当前即诶单的路径

        public UnionFind(Collection<Node> list){
            ArrayList<Node> list1 = (ArrayList)list;
            rank = new int[list.size()];
            parent = new int[list.size()];
            for(int i = 0 ; i < list.size() ; i ++){
                parent[i] = list1.get(i).value;
                rank[i] = 1;
            }
        }

        public  UnionFind(int capacity){
            parent = new int[capacity];
            rank = new int[capacity];
            for(int i = 0 ; i < capacity ; i ++){
                parent[i] = i;
                rank[i] = 1;
            }
        }

        private int find(int p){
            while (p != parent[p]){
                // 路径压缩
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public boolean isConnect(int p , int q){
            return find(p) == find(q);
        }


        public void union(int p , int q){

            int pRoot = find(p);
            int qRoot = find(q);

            if(pRoot == qRoot){
                return;
            }

            if(rank[pRoot] > rank[qRoot]){
                parent[qRoot] = pRoot;
            }else if(rank[pRoot] < rank[qRoot]){
                parent[pRoot] = qRoot;
            }else{
                parent[pRoot] = qRoot;
                rank[qRoot] += 1;
            }
        }

    }


    // kruskal 最小生成树的算法
    // 依次找到权值最小的边， 依次加入树中，判断是否有环产生
    public static Set<Edge> kruskalMST(Graph graph){

        UnionFind unionFind = new UnionFind(graph.nodes.values());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((o1 , o2) -> {return o1.weight - o2.weight;});
        for(Edge edge : graph.edges){
            priorityQueue.add(edge);
        }

        Set<Edge> result = new HashSet<>();
        while(!priorityQueue.isEmpty()){
            Edge edge = priorityQueue.poll();
            if(!unionFind.isConnect(edge.to.value , edge.from.value)){
                result.add(edge);
                unionFind.union(edge.to.value , edge.from.value);
            }
        }
        return result;
    }


}
