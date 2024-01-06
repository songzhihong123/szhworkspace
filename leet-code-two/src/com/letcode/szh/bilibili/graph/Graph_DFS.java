package com.letcode.szh.bilibili.graph;

import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName Graph_DFS
 * @Description 图的深度度优先遍历
 * @Author szh
 * @Date 2024年01月05日
 */
public class Graph_DFS {


    //图的深度度优先遍历
    public static void def(Node node){
        if(node == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        // 节点入栈的时候处理
        System.out.println(node.value);
        while(!stack.isEmpty()){
            Node popNode = stack.pop();
            for (Node next : popNode.nexts) {
                if(!set.contains(next)){
                    // set 中存在，把出栈的节点和当前节点压入栈中，栈里面一直保持深度的节点
                    stack.push(popNode);
                    stack.push(next);
                    System.out.println(next);
                    break;
                }
            }

        }

    }

}
