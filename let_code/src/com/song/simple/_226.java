package com.song.simple;

public class _226 {


    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode cur = root.left;
        root.left = root.right;
        root.right = cur;

        invertTree1(root.left);
        invertTree1(root.right);

        return root;
    }




    public static void main(String[] args){
        _226 obj = new _226();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        obj.invertTree(root);


    }


}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){

    }
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val , TreeNode left , TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
