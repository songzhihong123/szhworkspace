package com.letcode.szh.bilibili;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName IsCBT
 * @Description IsCBT
 * @Author szh
 * @Date 2024年01月04日
 */
public class IsCBT {

    /**
     *
     *
     * 如何判断一棵树是不是完全二叉树？
     *  a、任意节点有右孩子，没有左孩子
     *  b、满足a条件的节点后面的节点全是叶子节点
     *
     */

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


    // 如何判断一棵树是不是完全二叉树
    public static boolean isCBT(Node head){
        if(head == null){
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        // 是否遇到了不双全的节点
        boolean leaf = false;

        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            Node leftNode = curNode.left;
            Node rightNode = curNode.right;

            if(leaf && (leftNode != null || rightNode != null)){
                return false;
            }

            if(leftNode == null && rightNode !=null){
                return false;
            }

            if(leftNode != null){
                queue.add(leftNode);
            }

            if(rightNode != null){
                queue.add(rightNode);
            }

            if(leftNode == null || rightNode == null){
                leaf = true;
            }

        }

        return true;
    }


    public static class ReturnData{

        public boolean isBST;

        public int min;

        public int max;

        ReturnData(boolean isBST , int min , int max){
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }


    // 判断以node为节点的树是不是一颗二分搜索树
    public static ReturnData process(Node node){
        if(node == null){
            return null;
        }

        ReturnData leftData = process(node.left);
        ReturnData rightData = process(node.right);

        int min = node.e;
        int max = node.e;
        if(leftData != null){
            min = Math.min(leftData.min , min);
            max = Math.max(leftData.max , max);
        }
        if(rightData != null){
            min = Math.min(rightData.min , min);
            max = Math.max(rightData.max , max);
        }

        boolean isBST = true;
        if(leftData != null && (!leftData.isBST || leftData.max >= node.e)){
            isBST =false;
        }
        if(rightData != null && (!rightData.isBST || rightData.min <= node.e)){
            isBST =false;
        }

        return new ReturnData(isBST , min , max);
    }



    //判断以node为节点的树是不是一颗满二叉树
    // 满二叉树的定义： 满二叉树的所有节点数量等于(2^L- 1) , L 是树的高度
    public static boolean isF(Node head){
        if(head == null){
            return true;
        }
        Info data = f(head);
        return data.nodes == (1 << data.height - 1);
    }

    public static class Info{
        public int height;
        public int nodes;

        public Info(int height , int nodes){
            this.height = height;
            this.nodes = nodes;
        }
    }


    public static Info f(Node node){
        if(node == null){
            return new Info(0 , 0);
        }
        Info leftInfo = f(node.left);
        Info rightInfo = f(node.right);

        int height = Math.max(leftInfo.height , rightInfo.height) + 1;
        int nodes = leftInfo.nodes + rightInfo.nodes + 1;

        return new Info(height , nodes);
    }



    // 判断以node为节点的树是不是一颗满二叉树
    public static boolean  isFull(Node node){
        if(node == null){
            return true;
        }

        if(node.left != null && node.right == null){
            return false;
        }

        if(node.right != null && node.left == null){
            return false;
        }


        return isFull(node.left) && isFull(node.right);
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        System.out.println(isFull(node1));


    }




}
