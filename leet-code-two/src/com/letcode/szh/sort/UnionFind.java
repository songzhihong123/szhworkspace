package com.letcode.szh.sort;

/**
 * @ClassName UnionFind
 * @Description 并查集
 * @Author szh
 * @Date 2024年01月01日
 */
public class UnionFind {

    // parent[i] 表示i节点的父亲节点
    private int[] parent;

    // rank[i] 表示节点i的路径的高度
    private int[] rank;

    // 构造函数
    public UnionFind(int capacity){
        parent = new int[capacity];
        rank = new int[capacity];
        for(int i = 0 ; i < capacity ; i ++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int size(){
        return parent.length;
    }

    // 查找节点p对应的根节点
    private int find(int p){
        if(p < 0 || p >= parent.length){
            throw new IllegalArgumentException("p is illega.");
        }

        while(p != parent[p]){
            // 路径压缩
            parent[p] = parent[parent[p]];
            p = parent[p];
        }

        return p;
    }



    //判断两个节点是否联通
    public boolean isConnect(int p , int q){
        // 判断p节点的根节点和q节点的根节点是否相等
        return find(p) == find(q);
    }


    //union操作将两个节点连通起来
    public void unionElements(int p , int q){
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot){
            return;
        }

        // p节点的高度大于q节点
        if(rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot;
        }else if(rank[pRoot] < rank[qRoot]){
            // p节点的高度小于q节点
            parent[pRoot] = qRoot;
        }else{
            // p节点的高度等于q节点
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }

    }





}
