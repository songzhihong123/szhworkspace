package com.letcode.szh.bilibili.middle;

/**
 * @ClassName CompleteTreeNodeNumber
 * @Description CompleteTreeNodeNumber
 * @Author szh
 * @Date 2024年01月15日
 */
public class CompleteTreeNodeNumber {

    /*

    求一个完全二叉树的节点个数

//    重点：需要拿右子树的最左节点的高度来判断

    思路：
    （1）如果一个节点的右子树的最左节点不为空，则当前节点的左子树是一个满二叉树

    （2）如果一个节点的右子树的最左节点为空，则当前节点的右子树是一个满二叉树 ， 高度比总高度减1

     */
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    // 求以node为头节点的完全二叉树的深度
    public static int mostLeftLevel(Node node, int level){
        while(node != null){
            level ++;
            node = node.left;
        }
        return level - 1;
    }

    //求以head为头节点的完全二叉树的节点个数
    public static int nodeNum(Node head){
        if(head == null){
            return 0;
        };
        return bs(head , 1, mostLeftLevel(head , 1));
    }


    // node在level层， h是总深度
    // 求以node为头的完全二叉树， 节点个数是多少
    public static int bs(Node node , int level , int h){
        if(level == h){
            return 1;
        }

        // 如果节点的右子树的高度 + 1 和 当前高度一样，则表示当前节点的右子树的最左节点的高度和右子树的高度一致
        if(mostLeftLevel(node.right , level + 1) == h){
            // 当前节点的左子树是满二叉树 满二叉树的节点个数 = 2 ^ L - 1 , L表示数的高度 ， 
            // 这里加一表示算上当前树的头节点
            return (1 << (h - level)) - 1 + 1 + bs(node.right , level + 1, h);
        }else{
            // 当前节点的右子树是满二叉树
            return (1 << (h - level - 1)) - 1 + 1 + bs(node.left , level + 1 , h);
        }


    }


    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);


        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node4.left = node8;
        node4.right = node9;

        node5.left = node10;
        node5.right = node11;

        node6.left = node12;
//        node6.right = node13;



        System.out.println(nodeNum(node1));
    }





}
