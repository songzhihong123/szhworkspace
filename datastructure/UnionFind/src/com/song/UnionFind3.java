package com.song;

//第三版的Union-Find
public class UnionFind3 implements UF {

    private int[] parent;
    private int[] sz;  //sz[i] 表示以1为根的集合的元素的个数

    public UnionFind3(int size){
        parent = new int[size];
        sz = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public int getSize(){
        return parent.length;
    }

    //查找过程，查找元素p所对应的集合编号
    //O(h) 复杂度，h 为树的高度
    private int find(int p){
        if (p < 0 || p > parent.length)
            throw new IllegalArgumentException("p is out of bound.");
        //这是一个不断索引的过程，不是访问一段连续的空间
        while(parent[p] != p){
            p = parent[p];
        }
        return p;
    }

    //查看元素p和元素q是否所属一个集合
    //O(h)复杂度，h为树的高度
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    //合并元素p和元素q所属的集合
    //O(h)复杂度，h为树的高度
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot)
            return;

        //根据两个元素所在树的元素个数不同判断合并的方向
        //将元素的个数少的集合合并到元素个数多的集合上
        if(sz[pRoot] < sz[qRoot]){
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }else{ //sz[pRoot] < sz[qRoot]
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }

    }
}
