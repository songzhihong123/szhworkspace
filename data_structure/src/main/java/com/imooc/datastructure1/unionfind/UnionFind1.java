package com.imooc.datastructure1.unionfind;

/**
 * @ClassName UnionFind1
 * @Description UnionFind1
 * @Author szh
 * @Date 2023年11月24日
 */
public class UnionFind1 implements UF{

    private int[] ids;

    public UnionFind1(int size){
        ids = new int[size];
        for (int i = 0 ; i < ids.length ; i ++){
            ids[i] = i;
        }
    }

    @Override
    public int getSize() {

        return ids.length;
    }
    // 查找元素p所对应的集合编号
    private int find(int p){
        if(p < 0 || p >= ids.length){
            throw new IllegalArgumentException("p is out of bound.");
        }
        return ids[p];
    }

    // 查看元素p和元素q是否属于一个集合
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 将两个元素合并
    @Override
    public void unElements(int p, int q) {

        int pID = find(p);
        int qID = find(q);

        if(pID == qID){
            return;
        }
        for (int i = 0 ; i < ids.length ; i ++){
            if(ids[i] == pID){
                ids[i] = qID;
            }
        }
    }


}
