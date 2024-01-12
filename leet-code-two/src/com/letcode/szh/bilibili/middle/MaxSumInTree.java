package com.letcode.szh.bilibili.middle;

/**
 * @ClassName MaxSumInTree
 * @Description MaxSumInTree
 * @Author szh
 * @Date 2024年01月11日
 */
public class MaxSumInTree {

    /*

    求一棵树的根节点去往每一个叶子节点的最大值

    一个节点有一个值
     */

    public static class Node{
        private int value;

        private Node left;

        private Node right;

        public Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }

    public static int maxDis(Node head){
        if(head == null){
            return 0;
        }
        return maxValue(head);
    }


    // 我自己
    public static int maxValue(Node node){
        if(node == null){
            return 0;
        }

        if(node.left == null && node.right == null){
            return node.value;
        }

        int leftMaxValue = maxValue(node.left);
        int rightMaxValue = maxValue(node.right);

        return node.value + Math.max(leftMaxValue , rightMaxValue);
    }

    // 视频
    // 自己写的和视频的效果是一样的
    public static int maxValue1(Node node){
        if(node == null){
            return 0;
        }

        if(node.left == null && node.right == null){
            return node.value;
        }

        int next = Integer.MIN_VALUE;

        if(node.left != null){
            next = maxValue1(node.left);
        }

        if(node.right != null){
            next = Math.max(maxValue1(node.right) , next);
        }

        return node.value + next;
    }

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        Node node4 = new Node(3);
        Node node5 = new Node(2);
        Node node6 = new Node(7);
        Node node7 = new Node(5);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;


        System.out.println(maxValue(node1));
        System.out.println(maxValue1(node1));




    }




}
