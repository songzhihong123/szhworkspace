package com.letcode.szh.bilibili.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @ClassName Graph_BFS
 * @Description 图的宽度优先遍历
 * @Author szh
 * @Date 2024年01月05日
 */
public class Graph_BFS {


    // 图的优先遍历
    public static void bfs(Node node){
        if(node == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while(!queue.isEmpty()){
           Node poll = queue.poll();
            System.out.println(poll.value);
            for (Node next : poll.nexts) {
                if(!set.contains(next)){
                    queue.add(next);
                    set.add(node);
                }
            }
        }

    }



}
