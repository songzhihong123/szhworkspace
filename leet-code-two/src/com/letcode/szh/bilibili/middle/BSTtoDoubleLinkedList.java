package com.letcode.szh.bilibili.middle;

/**
 * @ClassName BSTtoDoubleLinkedList
 * @Description BSTtoDoubleLinkedList
 * @Author szh
 * @Date 2024年01月14日
 */
public class BSTtoDoubleLinkedList {


    /*
    二分搜索数 转为 有序的双向列表
     */

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }

    }


    public static class Info{

        private Node start;
        private Node end;

        Info(Node start , Node end){
            this.start = start;
            this.end = end;
        }


    }


    public static Node convert(Node head){
        if(head == null){
            return null;
        }

        return process(head).start;
    }


    // 将头节点为node节点的二分搜索转为双链表
    public static Info process(Node node){
        if (node == null){
            return new Info(null , null);
        }

        Info leftInfo = process(node.left);

        Info rightInfo = process(node.right);

        if(leftInfo.end != null){
            leftInfo.end.right = node;
        }
        node.left = leftInfo.end;


        if(rightInfo.start.left != null){
            rightInfo.start.left = node;
        }
        node.right = rightInfo.start;

        return new Info(leftInfo.start == null ? leftInfo.start : node ,
                rightInfo.end == null ? rightInfo.end : node);
    }









}
