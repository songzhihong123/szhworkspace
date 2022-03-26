package com.song.simple.day8;

import java.util.LinkedList;
import java.util.Queue;

public class _617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }

        TreeNode merged = new TreeNode(root1.val + root2.val);
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue.offer(merged);
        queue1.offer(root1);
        queue2.offer(root2);

        while(!queue1.isEmpty() && !queue2.isEmpty()){
            TreeNode poll = queue.poll() , poll1 = queue1.poll() , poll2 = queue2.poll();
            TreeNode left1 = poll1.left , left2 = poll2.left , right1 = poll1.right , right2 = poll2.right;
            if(left1 != null || left2 != null){
                if(left1 != null && left2 != null){
                    TreeNode left = new TreeNode(left1.val + left2.val);
                    poll.left = left;
                    queue1.offer(left1);
                    queue2.offer(left2);
                    queue.offer(left);
                }else if(left1 != null){
                    poll.left = left1;
                }else if(left2 != null){
                    poll.left = left2;
                }
            }
            if(right1 != null || right2 != null){
                if(right1 != null && right2 != null){
                    TreeNode right = new TreeNode(right1.val + right2.val);
                    poll.right = right;
                    queue1.offer(right1);
                    queue2.offer(right2);
                    queue.offer(right);
                }else if(right1 != null){
                    poll.right = right1;
                }else if(right2 != null){
                    poll.right = right2;
                }
            }
        }
        return merged;
    }

    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }

        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees1(root1.left , root2.left);
        merged.right = mergeTrees1(root1.right , root2.right);

        return merged;
    }


    public static void main(String[] args){

    }



}

class TreeNode {
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
