package com.imooc.datastructure1.unionfind;

/**
 * @ClassName UF
 * @Description UF
 * @Author szh
 * @Date 2023年11月24日
 */
public interface UF {

    int getSize();

    boolean isConnected(int p , int q);

    void unElements(int p , int q);

}
