package com.song;

//第一版的Union-Find
public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size){
        id = new int[size];
        //一个元素对应一个下标
        //第0个元素对应的是零，第一个元素对应的是一，第二个元素对应的是二 .......
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize(){
        return id.length;
    }

    //查询元素p对应的元素编号
    private int find(int p){
        if (p < 0 || p > id.length)
            throw new IllegalArgumentException("p is out of bound.");
        return id[p];
    }

    //查看元素p和元素q是否所属一个集合
    @Override
    public boolean isConnected(int p , int q){
        return find(p) == find(q);
    }

    //合并元素p和元素q所属的集合
    @Override
    public void unionElements(int p , int q){

        int pID = find(p);

        int qID = find(q);

        if (pID == qID)
            return;

        for (int i = 0; i < id.length; i++) {
            if(id[i] == pID)
                id[i] = qID;
        }

    }




}
