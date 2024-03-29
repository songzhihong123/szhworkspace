package com.imooc.datastructure.avl;

import java.util.ArrayList;

public class AVLTree<K extends Comparable<K>, V>{


    private class Node{
        public K key;
        public V value;
        public Node left , right;
        public int height;

        public Node(K key , V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree(){
        root = null;
        size = 0;
    }

    // 获取节点node的高度
    private int getHeight(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    // 判断该二叉树是否一颗平衡二叉树
    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node){
        if(node == null){
            return true;
        }

        if(Math.abs(getBalanceFactor(node)) > 1){
            return false;
        }

        return isBalanced(node.left) && isBalanced(node.right);
    }


    // 判断二叉树是否一颗二分搜索树
    public boolean isBST(){
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root , keys);
        for (int i = 1; i < keys.size(); i++) {
            if(keys.get(i).compareTo(keys.get(i - 1)) < 0){
                return false;
            }
        }
        return true;
    }

    // 二分搜索树的中序遍历
    private void inOrder(Node node , ArrayList<K> keys){
        if(node == null){
            return;
        }

        inOrder(node.left,keys);
        keys.add(node.key);
        inOrder(node.right,keys);
    }


    // 获得节点node的平衡因子
    private int getBalanceFactor(Node node){
        if(node == null){
            return 0;
        }
        return getHeight(node.left) + getHeight(node.right);
    }

    public void add(K key, V value) {
        add(root , key , value);
    }

    // 向以node为根的二分搜索树中插入元素e，递归算法
    private Node add(Node node , K key , V value){
        if(node == null){
            size ++;
            return new Node(key , value);
        }
        if (key.compareTo(node.key) < 0){
            node.left = add(node.left , key , value);
        }else if(key.compareTo(node.key) > 0){
            node.right = add(node.right , key , value);
        }else {
            node.value = value;
        }
        // 更新 height
        node.height = Math.max(getHeight(node.left) , getHeight(node.right)) + 1;
        int balanceFactor = getBalanceFactor(node);
        if(Math.abs(balanceFactor) > 1){
            System.out.println("unbalance : " + balanceFactor);
        }
        return node;
    }

    private Node getNode(Node node, K key){
        if(node == null){
            return null;
        }
        if(node.key.compareTo(key) > 0){
            return getNode(node.left , key);
        }else if(node.key.compareTo(key) < 0){
            return getNode(node.right , key);
        }else{
            return node;
        }
    }

    public V remove(K key) {

        Node node = getNode(root , key);
        if(node != null){
            root = remove(root, key);
            return  node.value;
        }
        return null;
    }

    private Node remove(Node node , K key){
        if (node == null){
            return null;
        }
        if (key.compareTo(node.key) < 0){
            node.left = remove(node.left , key);
            return node;
        }else if(key.compareTo(node.key) > 0){
            node.right = remove(node.right , key);
            return node;
        }else{
            // 待删除节点的左子树为空
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            // 待删除节点的右子树为空
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            //待删除节点的左右子树都不为空的时候
            // 找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            Node successor = minimum(node.right);
            // 用这个节点来替换待删除节点的位置
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }

    }

    // 返回以node为根的二分搜素树的最小值所在的节点
    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    //删除掉以node为根的二分搜素树中的最小节点
    //返回删除节点后新的二分搜素树的根
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

    public boolean contains(K key) {
        return getNode(root , key) != null;
    }

    public V get(K key) {

        Node node = getNode(root, key);

        return node == null ? null : node.value;
    }

    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null){
            throw new IllegalArgumentException(key + "doesn't exits");
        }else{
            node.value = newValue;
        }


    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
