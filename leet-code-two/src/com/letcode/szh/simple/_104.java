package com.letcode.szh.simple;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName _104
 * @Description _104
 * @Author szh
 * @Date 2023年12月30日
 */
public class _104 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 求以root为根节点的二叉树的最大高度
    public int maxDepth(TreeNode root) {

        if(root == null){
            return 0;
        }

        int leftLen = maxDepth(root.left);
        int rightLen = maxDepth(root.right);



        return Math.max(leftLen , rightLen) + 1;
    }


    public static void main(String[] args) {
        _104 obj = new _104();


    }


}
