package com.imooc.datastructure1.unionfind;

/**
 * @ClassName UnionFind2
 * @Description UnionFind2
 * @Author szh
 * @Date 2023年11月24日
 */
public class UnionFind2 implements UF{

    private int[] parent;

    public  UnionFind2(int size){
        parent = new int[size];
        for(int i = 0 ; i < parent.length ; i ++){
            parent[i] = i;
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

        parent[pRoot] = qRoot;
    }


}
