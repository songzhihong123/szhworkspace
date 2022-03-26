package com.song.simple;/**
 * Created by Zhihong Song on 2021/4/27 15:15
 */

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: let_code
 * @description:
 * @author: szh
 * @create: 2021-04-27 15:15
 **/
public class _938 {



    public int rangeSumBST(TreeNode root, int low, int high) {
       if(root == null){
           return 0;
       }
       if(root.val > high){
            return rangeSumBST(root.left , low , high);
       }
       if(root.val < low){
           return rangeSumBST(root.right , low , high);
       }
       return root.val + rangeSumBST(root.left ,low , high) + rangeSumBST(root.right , low , high);
    }

    public int rangeSumBST1(TreeNode root, int low, int high) {
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                continue;
            }
            if(node.val > high){
                q.offer(node.left);
            }else if(node.val < low){
                q.offer(node.right);
            }else {
                sum += node.val;
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return sum;
    }




    public static void main(String[] args){


    }


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

}
