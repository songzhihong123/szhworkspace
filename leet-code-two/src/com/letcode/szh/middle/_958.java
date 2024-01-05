package com.letcode.szh.middle;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName _958
 * @Description 二叉树的完全性校验
 * @Author szh
 * @Date 2024年01月04日
 */
public class _958 {

    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }



      /*
      除了最后一层外，所有层都被完全填满，并且最后一层中的所有节点都尽可能靠左
       */


    // 判断一颗树是不是完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 是否出现了没有左孩子或者右孩子的节点
        boolean isLeaf = false;

        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();

            // 出现了没有左孩子或者右孩子的节点 ，并且出现了后面的节点存在右孩子节点的时候
            if(isLeaf && (cur.left != null || cur.right != null)){
                return false;
            }
            // 节点存在右孩子节点，不存在左孩子节点
            if(cur.right != null && cur.left == null){
                return false;
            }

            if(cur.left != null){
                queue.add(cur.left);
            }

            if(cur.right != null){
                queue.add(cur.right);
            }

            if(cur.left == null || cur.right == null){
                isLeaf = true;
            }
        }
        return true;
    }





}
