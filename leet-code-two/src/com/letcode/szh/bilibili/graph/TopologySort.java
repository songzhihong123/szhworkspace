package com.letcode.szh.bilibili.graph;

import java.util.*;

/**
 * @ClassName TopologySort
 * @Description 拓扑排序
 * @Author szh
 * @Date 2024年01月05日
 */
public class TopologySort {



    // 拓扑排序：依次输出入度为0的节点 ， 删除当前入度为0的点，对其他节点的影响
    public static List<Node> sortedTopology(Graph graph){

        // 记录每个点对应的入度
        HashMap<Node, Integer> inMap = new HashMap<>();

        // 记录入度为零的点
        Queue<Node> zeroInQueue = new LinkedList<>();

        for (Node node : graph.nodes.values()){
            inMap.put(node , node.in);
            if(node.in == 0){
                zeroInQueue.add(node);
            }
        }

        List<Node> res = new ArrayList<>();
        while(!zeroInQueue.isEmpty()){
            Node poll = zeroInQueue.poll();
            res.add(poll);
            for (Node node : poll.nexts){
                inMap.put(node , inMap.get(node) - 1);
                if(inMap.get(node) == 0){
                    zeroInQueue.add(node);
                }
            }
        }
        return res;
    }







}
