package com.letcode.szh.bilibili.graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName Graph
 * @Description 图
 * @Author szh
 * @Date 2024年01月05日
 */
public class Graph {

    // key 表示节点的值 ， value指一个点
    public HashMap<Integer , Node> nodes;
    // 当前节点的边集
    public HashSet<Edge> edges;

    Graph(){
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }

}
