package com.letcode.szh.bilibili.graph;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @ClassName Prim
 * @Description Prim 生成最小生成树
 * @Author szh
 * @Date 2024年01月05日
 */
public class Prim {



    // Prim 生成最小生成树， 以一个节点开始去找最小的边，依次连起来
    public static Set<Edge> primMST(Graph graph){

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((o1 , o2) -> {return o1.weight - o2.weight;});

        // 依次挑选的点在set里面
        HashSet<Node> set = new HashSet<>();

        Set<Edge> result = new HashSet<>();

        // 外层的for循环是为了处理森林的问题， 就是出现了多个不连通的图
        for(Node node : graph.nodes.values()){
            if(!set.contains(node)){
                set.add(node);
                for (Edge edge : node.edges) {
                    priorityQueue.add(edge);
                }
                while(!priorityQueue.isEmpty()){
                    Edge edge = priorityQueue.poll(); // 弹出解锁的边中最小的边
                    Node toNode = edge.to; // 可能的一个新的节点
                    if(!set.contains(toNode)){
                        set.add(toNode);
                        result.add(edge);
                        for (Edge nextEdge : toNode.edges) {
                            priorityQueue.add(nextEdge);
                        }

                    }
                }
            }

        }
        return result;
    }






}
