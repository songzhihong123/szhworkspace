package com.imooc.datastructure.unionFind;

public class UnionFind4 implements UF{


    private int[] parent;
    private int[] rank; // rank[i] 表示就是以i为根的集合所表示树的层次
    public UnionFind4(int size){
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }


    // 查找过程，查找元素p所对应的集合编号
    private int find(int p){
        if(p < 0 || p >= parent.length){
            throw new IllegalArgumentException("p is out of bound.");
        }
        while(p != parent[p]){
            p = parent[p];
        }
        return p;
    }

    private int find1(int p){
        if(p == parent[p]){
            return p;
        }
        p = parent[p];
        return find1(p);
    }


    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot){
            return;
        }

        // 根据两个元素所在树的元素个数不同判断合并方向
        // 将两个元素个数少的集合合并到元素个数多的集合上面
        if(rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;
        }else if((rank[pRoot] > rank[qRoot])){
            parent[qRoot] = pRoot;
        }else{
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }

    }

    @Override
    public int getSize() {
        return parent.length;
    }
}
