package com.letcode.szh.bilibili.graph;

import java.util.ArrayList;

/**
 * @ClassName Node
 * @Description 点
 * @Author szh
 * @Date 2024年01月05日
 */
public class Node {

    // 当前节点的值
    public int value;
    // 节点的入度
    public int in;
    // 节点的出度
    public int out;
    // 当前节点的相邻的节点
    public ArrayList<Node> nexts;
    // 当前节点相邻的边
    public ArrayList<Edge> edges;

    public Node(int value){
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }


}
