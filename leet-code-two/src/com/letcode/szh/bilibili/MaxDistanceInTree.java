package com.letcode.szh.bilibili;

/**
 * @ClassName MaxDistanceInTree
 * @Description MaxDistanceInTree
 * @Author szh
 * @Date 2024年01月08日
 */
public class MaxDistanceInTree {


    /*
    二叉树节点的最大距离问题

    从二叉树的节点a出发，可以向上或者向下走，单沿途的节点只能经过一次，到达
    节点b是路径上的节点个数叫做a到b的距离，那么二叉树任何两个即诶单之间都有距离
    求整棵树上的最大距离

     */

    public static class Node {

        public int value;

        public Node left;

        public Node right;

        public Node(int value){
            this.value = value;
        }

    }

    public static int maxDistance(Node head){
        return process(head).maxDistance;
    }



    public static class Info{

        public int maxDistance;
        public int height;

        public Info(int maxDistance , int height){
            this.maxDistance = maxDistance;
            this.height = height;
        }

    }

    // 返回以node为头的数的两个信息
    public static Info process(Node node){
        if(node == null){
            return new Info(0 , 0);
        }

        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        int height = Math.max(leftInfo.height , rightInfo.height) + 1;
        int p1 = leftInfo.maxDistance;
        int p2 = rightInfo.maxDistance + 1;
        int p3 = leftInfo.maxDistance + rightInfo.maxDistance + 1;
        int maxDistance = Math.max(p3 , Math.max(p1 , p2));
        return new Info(maxDistance , height);
    }






}
