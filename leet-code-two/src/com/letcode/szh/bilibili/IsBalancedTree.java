package com.letcode.szh.bilibili;

/**
 * @ClassName IsBalancedTree
 * @Description 判断是否是平衡二叉树
 * @Author szh
 * @Date 2024年01月04日
 */
public class IsBalancedTree {


    /**
     * 判断是否是平衡二叉树
     */

    public class Node{

        public int e;

        public boolean color;

        public Node left , right;

        public Node(int e){
            this.e = e;
            left = null;
            right = null;
        }

    }

    public static class ReturnType{

        public boolean isBalanced;

        public int height;

        ReturnType(boolean isBalanced , int height){
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static boolean isBalanced(Node head){
        return process(head).isBalanced;
    }

    // 判断以节点node为根的树是不是平衡二叉树
    public static ReturnType process(Node node){
        if(node == null){
            return new ReturnType(true , 0);
        }

        ReturnType leftData = process(node.left);
        ReturnType rightData = process(node.right);

        int height = Math.max(leftData.height , rightData.height) + 1;
        boolean isBalance = leftData.isBalanced && rightData.isBalanced &&
                (Math.abs(leftData.height - rightData.height) <= 1);

        return new ReturnType(isBalance , height);
    }




}
