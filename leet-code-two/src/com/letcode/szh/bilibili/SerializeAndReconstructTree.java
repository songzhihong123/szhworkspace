package com.letcode.szh.bilibili;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName SerializeAndReconstructTree
 * @Description 树的序列话和反序列化
 * @Author szh
 * @Date 2024年01月04日
 */
public class SerializeAndReconstructTree {

    public static class Node{

        public int e;

        public boolean color;

        public Node left , right;

        public Node(int e){
            this.e = e;
            left = null;
            right = null;
        }

    }

    // 将一个以head为头节点的树序列化为字符串
    // 前序遍历的方式
    public static String serialByPre(Node node){
        if(node == null){
            return "#_";
        }
        String str = node.e +"_";
        str += serialByPre(node.left);
        str += serialByPre(node.right);
        return str;
    }

    // 将一个字符串反序列化为一个树，返回头节点
    public static Node reconByPreString(String preStr){
        String[] splitArr = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for(String str : splitArr){
            queue.add(str);
        }
        return reconPreOrder(queue);
    }

    public static Node reconPreOrder(Queue<String> queue){
        String poll =  queue.poll();
        if(poll.equals("#")){
            return null;
        }
        Node head = new Node(Integer.parseInt(poll));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }




}
