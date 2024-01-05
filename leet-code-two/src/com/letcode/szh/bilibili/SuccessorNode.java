package com.letcode.szh.bilibili;

/**
 * @ClassName SuccessorNode
 * @Description 找一个节点的后继节点
 * @Author szh
 * @Date 2024年01月04日
 */
public class SuccessorNode {


    /*
    找一个节点的后继节点
    后继节点：一棵树中序遍历之后的节点的后一个节点
     */

    public static class Node{

        public int e;

        public Node left , right , parent;

        public Node(int e){
            this.e = e;
            left = null;
            right = null;
        }

    }


    public static Node successorNode(Node node){
        if(node == null){
            return null;
        }
        if(node.right != null){ // 右树不为空
            return getLeftMost(node.right);
        }else{ // 右树为空
            Node parent = node.parent;
            // 父亲节点为空 ｜ 当前节点是父亲节点的左节点停止
            while(parent != null && parent.left != node){ // 当前节点是其父亲节点的右孩子
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node){
        if(node == null){
            return null;
        }
        while(node.left != null){
            node = node.left;
        }
        return node;
    }



}
