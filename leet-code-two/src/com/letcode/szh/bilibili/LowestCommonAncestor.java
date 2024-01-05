package com.letcode.szh.bilibili;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName LowestCommonAncestor
 * @Description 求两个节点的公共祖先
 * @Author szh
 * @Date 2024年01月04日
 */
public class LowestCommonAncestor {


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

    // o1和o2一定属于head为头的树
    // 返回o1和o2的最低公共祖先
    public static Node lowestCommonAncestor(Node head , Node o1 , Node o2){
        HashMap<Node, Node> fatherMap = new HashMap<>();
        fatherMap.put(head , head);
        process(head , fatherMap);

        Node cur = o1;
        HashSet<Node> s1 = new HashSet<>();
        s1.add(head);
        while(cur != fatherMap.get(cur)){
            s1.add(cur);
            cur = fatherMap.get(cur);
        }

        cur = o2;
        while(cur != fatherMap.get(cur)){
            if(s1.contains(cur)){
                return cur;
            }
            cur = fatherMap.get(cur);
        }
        return head;
    }

    // 将节点node和父节点对应起来
    public static void process(Node node , HashMap<Node, Node> fatherMap){
        if(node == null){
            return;
        }
        if(node.left != null){
            fatherMap.put(node.left , node);
        }
        if(node.right != null){
            fatherMap.put(node.right , node);
        }
        process(node.left , fatherMap);
        process(node.right , fatherMap);

    }

    // 返回以head为头节点的， 以head为根节点的树上 o1节点和o2节点 的最小公共祖先
    // 1、o1是o2的子对敌公共祖先 或者 o2是o1的子对敌公共祖先
    // 2、o1与o2不互为公共祖先
    public static Node lowestCommonAncestor2(Node head , Node o1 , Node o2){
        if(head == null || o1 == head || o2 == head){
            return head;
        }

        Node leftNode = lowestCommonAncestor2(head.left , o1 , o2);
        Node rightNode = lowestCommonAncestor2(head.right , o1 , o2);

        // o1与o2不互为公共祖先
        if(leftNode != null && rightNode != null){
            return head;
        }
        // 左右两颗树，并不都有值
        return leftNode != null ? leftNode : rightNode;
    }





}
