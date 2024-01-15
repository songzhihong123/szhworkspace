package com.letcode.szh.bilibili.middle;

/**
 * @ClassName BiggestSubBSTInTree
 * @Description BiggestSubBSTInTree
 * @Author szh
 * @Date 2024年01月14日
 */
public class BiggestSubBSTInTree {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }

    }



    public static class Info{

        public Node maxBSTHead;

        public boolean isBST;

        public int min;

        public int max;

        public int maxBSTSize;

        public Info(Node maxBSTHead , boolean isBST , int min , int max , int maxBSTSize){
            this.maxBSTHead = maxBSTHead;
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.maxBSTSize = maxBSTSize;
        }

    }




    public static Info process(Node node){
        if(node == null){
            return null;
        }

        Info leftInfo = process(node.left);

        Info rightInfo = process(node.right);


        int min = node.value;
        int max = node.value;


        if(leftInfo != null ){
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }

        if(rightInfo != null ){
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }


        int maxBSTSize = 0;
        Node maxBSTHead = null;
        boolean isBST = false;


        if(leftInfo != null ){
            maxBSTSize = leftInfo.maxBSTSize;
            maxBSTHead = leftInfo.maxBSTHead;
        }

        if(rightInfo != null && rightInfo.maxBSTSize > maxBSTSize){
            maxBSTSize = rightInfo.maxBSTSize;
            maxBSTHead = rightInfo.maxBSTHead;
        }



        if(
                ((leftInfo == null) || leftInfo.isBST)
                &&
                ((rightInfo == null || rightInfo.isBST))
        ){

            if(
                    ((leftInfo == null) || leftInfo.max < node.value)
                            &&
                    ((rightInfo == null || rightInfo.min > node.value))
            ){

                isBST = true;
                maxBSTHead = node;
                int leftSize = leftInfo == null ? 0 : leftInfo.maxBSTSize;
                int rightSize = rightInfo == null ? 0 : rightInfo.maxBSTSize;

                maxBSTSize = leftSize + rightSize + 1;

            }

        }


        return new Info(maxBSTHead , isBST , min , max , maxBSTSize);

    }




















}
