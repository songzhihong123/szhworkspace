package com.song;

//第二版的Union-Find
public class UnionFind2 implements UF{

    // parent[i]表示 第 i 个元素指向哪个节点
    private int[] parent;

    public UnionFind2(int size){
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
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
        // 找到当前节点的根节点
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
    // O(h)复杂度，h为树的高度
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot)
            return;
        parent[pRoot] = qRoot;
    }
}
