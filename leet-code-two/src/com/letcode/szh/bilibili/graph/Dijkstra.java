package com.letcode.szh.bilibili.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @ClassName Dijkstra
 * @Description 求最短路径算法
 *
 * @Date 2024年01月05日
 */
public class Dijkstra {

    /**
     *
     * 给一个出发点， 出发点到所有节点的最短节点
     * 没有权值是负数的边
     *
     */

    public static HashMap<Node , Integer> dijkstra1(Node head){

        // 表示从head出发到所有点的最小距离
        // key : 从head出发到所key
        // value: 从head出发到所key的最小距离
        // 如果在表中，没有T的记录， 含义是从head出发到T这个点的距离为正无穷
        HashMap<Node , Integer> distanceMap = new HashMap<>();
        distanceMap.put(head , 0);
        // 已经求过距离的节点，存在selectNodes中，以后再也不碰
        HashSet<Node> selectNode = new HashSet<>();

        Node minNode = getMinDistanceAndUnselectedNode(distanceMap , selectNode);
        while(minNode != null){
            int distance = distanceMap.get(minNode);
            // 遍历所有的边
            for(Edge edge : minNode.edges){
                Node toNode = edge.to;
                // 不存在则表示正无穷 ， 将值放进去
                if(!distanceMap.containsKey(toNode)){
                    distanceMap.put(toNode , distance + edge.weight);
                }else{
                    //更新， 比较存在的值 ，和当前距离加边的权值的哪个值小则取哪个值
                    distanceMap.put(toNode , Math.min(distanceMap.get(toNode) , distance + edge.weight));
                }

            }
            minNode = getMinDistanceAndUnselectedNode(distanceMap , selectNode);
        }

        return distanceMap;
    }


    // 求在distanceMap 中距离最小的点， 并且在selectNode中不包含
    public static Node getMinDistanceAndUnselectedNode(HashMap<Node , Integer> distanceMap , HashSet<Node> selectNode){
        Integer min = Integer.MAX_VALUE;
        Node minNode = null;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            if(!selectNode.contains(entry.getKey()) && entry.getValue() < min){
                min = entry.getValue();
                minNode = entry.getKey();
            }

        }
        return minNode;
    }





}
