package com.song.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Zhihong Song on 2021/1/19 9:56
 */

public class _1584 {

    //prim 算法
    public int minCostConnectPoints(int[][] points) {
        return prim(points);
    }

    //Kruskal
    public int minCostConnectPoints1(int[][] points) {
        return kruskal(points);
    }

    /**
     * Kruskal + 并查集  实现
     */
    public int kruskal(int[][] points){
        int len = points.length;
        //1. 构造图的点边式 两个顶点及两点间的长度
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                edges.add(new Edge(i,j,computeConst(points[i][0],points[i][1],points[j][0],points[j][1])));
            }
        }
        Collections.sort(edges,(e1,e2) -> e1.getLen() - e2.getLen());

        int res = 0;
        int num = 1;
        UnionFind unionFind = new UnionFind(len);
        for (Edge edge : edges) {
            int x = edge.start;
            int y = edge.end;
            int _len = edge.len;
            if(unionFind.union(x,y)){
                res += _len;
                num++;
                if (num == len){
                    break;
                }
            }

        }
        return res;
    }

    private class Edge{
        int start;
        int end;
        int len;

        public Edge(int start, int end, int len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }

        public int getLen() {
            return len;
        }
    }

    /**
     * 图论中的最小生成树Prim算法
     * @param points
     * @return
     */
    public int prim(int[][] points){
        int res = 0;
        //1.构造邻接矩阵
        int len = points.length;
        int[][] dp = new int[len][len]; // dp[0][1] 表示下标为0 到 下标为1 的 曼哈顿值
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if(i == j){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = computeConst(points[i][0],points[i][1],points[j][0],points[j][1]);
                    dp[j][i] = computeConst(points[i][0],points[i][1],points[j][0],points[j][1]);
                }
            }
        }
        // v_new    表示图中节点的访问情况，最开始全部为-1,表示未加入到v_new中，若某节点加入到了v_new中， 则将其置为0
        int[] v_new = new int[len];
        // lowcost  保存每个节点离v_new中所有节点的最短距离。初始化为Integer.MAX_VALUE，如果节点已经加入到了v_new中，则置为-1
        int[] lowcost = new int[len];

        for (int i = 0; i < len; i++) {
            v_new[i] = -1;
            lowcost[i] = Integer.MAX_VALUE;
        }

        //2.随机选取一个节点，默认为第一个节点,并且更新lowcost 里面的值
        v_new[0] = 0;
        for (int i = 0; i < len; i++) {
            if(i == 0){
                continue;
            }else {
                lowcost[i] = dp[0][i];
            }
        }

        //3. 遍历未放入v_new 的剩余的节点，
        for (int i = 1; i < len; i++) {
            // 找到图中离 v_new 最近的点
            int minIdx = -1; // minIdx 表示找到节点的下标
            int minVal = Integer.MAX_VALUE; // minVal 表示找到节点的下标对应的值
            for (int j = 0; j < len; j++) {
                if(lowcost[j] < minVal){
                    minIdx = j;
                    minVal = lowcost[j];
                }
            }

            //更新 v_new 里面的值
            res += minVal;
            v_new[minIdx] = 0;
            lowcost[minIdx] = Integer.MAX_VALUE;

            //更新 lowcost 里面的值
            for (int j = 0; j < len; j++) {
                if (v_new[j] == -1 && dp[j][minIdx] < lowcost[j]){
                    lowcost[j] =  dp[j][minIdx];
                }
            }
        }
        return res;
    }


    private int computeConst(int x1, int y1, int x2,int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }


    private class UnionFind{

        int[] parent;
        int[] rank;

        public UnionFind(int size){
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
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

        public boolean isConnected(int i, int j){
            return find(i) == find(j);
        }

        public boolean union(int p,int q){
            int pRoot = find(p);
            int qRoot = find(q);

            if (pRoot == qRoot){
                return false;
            }

            if(rank[pRoot] > rank[qRoot]){
                parent[qRoot] = pRoot;
            }else if(rank[pRoot] < rank[qRoot]){
                parent[pRoot] = qRoot;
            }else { // rank[pRoot] == rank[qRoot]
                parent[pRoot] = qRoot;
                qRoot += 1;
            }
            return true;
        }

    }




    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        _1584 obj = new _1584();
        System.out.println(obj.minCostConnectPoints1(points));
    }

}
