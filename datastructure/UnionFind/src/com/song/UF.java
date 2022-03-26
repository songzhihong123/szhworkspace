package com.song;
/**
 * 并查集是一种特殊的树结构，是由孩子指向父亲的树结构
 */
public interface UF {


    int getSize();

    boolean isConnected(int p , int q);

    void unionElements(int p , int q);



}
