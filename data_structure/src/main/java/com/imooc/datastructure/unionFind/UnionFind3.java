package com.imooc.datastructure.unionFind;

public class UnionFind3 implements UF{


    private int[] parent;
    private int[] sz; // sz[i] 表示就是以i为根的集合的元素个数
    public UnionFind3(int size){
        parent = new int[size];
        sz = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            sz[i] = 1;
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
        if(sz[pRoot] < sz[qRoot]){
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }else{
            parent[qRoot] = parent[pRoot];
            sz[pRoot] += sz[qRoot];
        }

    }

    @Override
    public int getSize() {
        return parent.length;
    }
}
