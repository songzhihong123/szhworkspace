package com.song.simple;/**
 * Created by Zhihong Song on 2021/4/25 9:08
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @program: let_code
 * @description:
 * @author: szh
 * @create: 2021-04-25 09:08
 **/
public class _897 {

    TreeNode dummyNode = new TreeNode(-1);
    TreeNode currNode = dummyNode;

    public TreeNode increasingBST(TreeNode root) {
        increasingBST(root.left);
        currNode.right = new TreeNode(root.val);
        currNode = currNode.right;
        increasingBST(root.right);
        return dummyNode.right;
    }




    public TreeNode increasingBST1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        createOrder(root,list);

       TreeNode dummyNode = new TreeNode(-1);
       TreeNode currNode = dummyNode;
       for (int in : list){
           currNode.right = new TreeNode(in);
           currNode = currNode.right;
       }
       return dummyNode.right;
    }

    public void createOrder(TreeNode node ,  List<Integer> res){
        if(node == null){
            return;
        }
        createOrder(node.left , res);
        res.add(node.val);
        createOrder(node.right,res);
    }


    public static void main(String[] args){

    }


     public static class TreeNode {
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
