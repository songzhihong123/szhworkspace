package com.imooc.datastructure1.bst;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName BST
 * @Description 二分搜索树
 * @Author szh
 * @Date 2023年09月03日
 */
public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left , right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }

    }


    private Node root;

    private int size;


    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // 向二分搜索树中添加新的元素e
    public void add(E e){
        root = add(root , e);
    }

    // 向一个根结点为node的树中添加元素e
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node , E e){
        if(node == null){
            size ++;
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0){
            node.left = add(node.left , e);
        }else if(e.compareTo(node.e) > 0){
            node.right = add(node.right , e);
        }
        return node;
    }


    // 看二分搜索树中是否包含元素e
    public boolean contains(E e){

        return contains(root , e);
    }

    // 看以node为根的二分搜索树中是否包含元素e
    private boolean contains(Node node , E e){
        if(node == null){
            return false;
        }

        if(e.compareTo(node.e) < 0){
            return contains(node.left , e);
        }else if(e.compareTo(node.e) > 0){
            return contains(node.right , e);
        }else{
            return true;
        }
    }

    // 二分搜索树的前序遍历
    public void preOrder(){
        preOrder(root);
    }

    // 前序遍历以node为根的二分搜索树
    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);

    }

    // 二分搜索树的前序遍历
    public void inOrder(){
        inOrder(root);
    }

    // 前序遍历以node为根的二分搜索树
    private void inOrder(Node node){
        if(node == null){
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);

    }


    // 二分搜索树的前序遍历
    public void postOrder(){
        postOrder(root);
    }

    // 前序遍历以node为根的二分搜索树
    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);

    }

    // 二分搜索树的层序遍历
    public  void levelOrder(){

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);

            if(cur.left != null){
                queue.add(cur.left);
            }else if(cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    // 寻找二分搜索树的最小元素
    public E minimum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty!");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }

        return minimum(node.left);
    }

    // 寻找二分搜索树的最大元素
    public E maximum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty!");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node){
        if(node.right .e== null){
            return node;
        }
        return maximum(node.right);
    }

    // 从二分搜素树中删除最小值所在节点，返回最小值
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中最小节点
    // 返回删除节点后新的二分搜素树的根
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }


    // 从二分搜素树中删除最大值所在节点，返回最小值
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }


    // 删除掉以node为根的二分搜索树中最大节点
    // 返回删除节点后新的二分搜素树的根
    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    // 从二分搜素树中删除元素为e的节点
    public void remove(E e){
        root = remove(root , e);
    }


    // 删除以node为根的二分搜素树中值为e的节点
    // 返回删除节点后新的二分搜索树的根
    private Node remove(Node node , E e){
        if(node == null){
            return null;
        }

        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left , e);
            return node;
        }else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right , e);
            return node;
        }else{
            // 待删除的节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            //待删除节点的右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            // 待删除节点的左右子树均不为空的时候

            // 找到当前节点的后继节点作为新节点
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            // node节点与之前的树脱离关系
            node.left = null;
            node.right = null;

            return successor;
        }

    }









    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root , 0 , res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node , int depth , StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth)).append("null\n");
            return;
        }

        res.append(generateDepthString(depth)).append(node.e).append("\n");
        generateBSTString(node.left , depth + 1 , res);
        generateBSTString(node.right , depth + 1 , res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0 ; i < depth ; i ++){
            res.append("--");
        }
        return res.toString();
    }




}
