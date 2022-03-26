package com.song.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Zhihong Song on 2021/4/13 13:44
 */

public class _783 {

//            4
//           / \
//          2   6
//         / \
//        1  3


    int res = Integer.MAX_VALUE;
    int pre = -1;

    /**
     * 中序遍历时有序的，我们需要考虑中序遍历的时候怎么样才能拿到前一个值与当前值减法计算
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {
        if(root == null){
            return -1;
        }
        minDiffInBST(root.left);
        if(pre == -1){
            pre = root.val;
        }else {
            res = Math.min(res , root.val - pre);
            pre = root.val;
        }
        minDiffInBST(root.right);
        return res;
    }



    public static void main(String[] args){
        _783 obj = new _783();
        TreeNode root = new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(6));
        System.out.println(obj.minDiffInBST(root));
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
