package com.imooc.datastructure1.unionfind;

/**
 * @ClassName UnionFind4
 * @Description UnionFind4
 * @Author szh
 * @Date 2023年11月24日
 */
public class UnionFind4 implements UF{

    private int[] parent;
    private int[] rank; // rank 表示以i为根的集合所表示数的层数

    public  UnionFind4(int size){
        parent = new int[size];
        rank = new int[size];
        for(int i = 0 ; i < parent.length ; i ++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    private int find(int p){
        if(p < 0 || p >= parent.length){
            throw new IllegalArgumentException("p is out of bound.");
        }
        while(p != parent[p]){
            p = parent[p];
        }
        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 将两个元素合并 , 将p对应的根节指向q对应的根节点
    @Override
    public void unElements(int p, int q) {

        int pRoot = find(p);

        int qRoot = find(p);

        if(pRoot == qRoot){
            return;
        }

        // 根据两个元素所载的数的rank不同判断合并方向
        // 将rank低的集合合并到rank高的集合上
        if(rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;
        }else if(rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot;
        }else{ // rank[pRoot] == rank[qRoot]
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }

}
