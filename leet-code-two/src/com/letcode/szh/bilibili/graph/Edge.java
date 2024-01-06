package com.letcode.szh.bilibili.graph;

/**
 * @ClassName Edge
 * @Description 边
 * @Author szh
 * @Date 2024年01月05日
 */
public class Edge {

    // 边的权重
    public int weight;
    // 从哪个节点出来的边
    public Node from;
    // 从哪个节点进来的边
    public Node to;

    public Edge(int weight , Node from , Node to){
        this.weight = weight;
        this.from = from;
        this.to = to;
    }


}
