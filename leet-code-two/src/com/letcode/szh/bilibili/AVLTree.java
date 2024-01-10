package com.letcode.szh.bilibili;

import java.util.Comparator;

/**
 * @ClassName AVLTree
 * @Description AVLTree
 * @Author szh
 * @Date 2024年01月10日
 */
public class AVLTree<K extends Comparable<K>, V> {

    private class Node{

        public K key;

        public V value;

        public int height;

        public Node left;

        public Node right;

        Node(K key , V value){
            this.key = key;
            this.value = value;
            height = 1;
            left = null;
            right = null;
        }

    }


    private Node root;

    private int size;

    AVLTree(){
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private int getHeight(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    private int getBalanceFactor(Node node){
        if(node == null){
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }



    public void add(K key , V value){
        add(root , key , value);
    }

    private Node add(Node node , K key , V value){
        if(node == null){
            size ++;
            return new Node(key , value);
        }

        if(key.compareTo(node.key) > 0){
            node.right = add(node.right , key , value);
        }else if(key.compareTo(node.key) < 0){
            node.left = add(node.left , key , value);
        }

        // 重新计算数的高度
        node.height = Math.max(node.left.height , node.right.height) + 1;

        // 求数的平衡因子
        int balanceFactor = getBalanceFactor(node);

        // LL
        if(balanceFactor > 1 && getBalanceFactor(node.left) >= 0){
            // 右旋转
            return rightRotate(node);
        }

        // RR
        if(balanceFactor < -1 && getBalanceFactor(node.right) >= 0){
            // 左旋转
            return leftRotate(node);
        }

        // LR
        if(balanceFactor > 1 && getBalanceFactor(node.left) <= 0){
            node.left = leftRotate(node.left);

           return rightRotate(node);
        }

        // RL
        if(balanceFactor < -1 && getBalanceFactor(node.right) <= 0){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }



    // 右旋转
    private Node rightRotate(Node y){

        Node x = y.left;

        y.left = x.right;
        x.right = y;

        y.height = Math.max(getHeight(y.left) , getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left) , getHeight(x.right)) + 1;

        return x;
    }


    // 左旋转
    private Node leftRotate(Node y){
        Node x = y.right;

        y.right = x.left;
        x.left = y;

        y.height = Math.max(getHeight(y.left) , getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left) , getHeight(x.right)) + 1;

        return x;
    }





    public boolean contains(K key){
        return contains(root , key);
    }

    private boolean contains(Node node , K key){
        if(node == null){
            return false;
        }

        if(key.compareTo(node.key) > 0){
            return contains(node.right , key);
        }else if(key.compareTo(node.key) < 0){
            return contains(node.left , key);
        }else{
            return true;
        }
    }

    private Node mininums(Node node){
        if(node.left == null){
            return node;
        }
        return mininums(node.left);
    }

    private Node maxinums(Node node){
        if(node.right == null){
            return node;
        }
        return maxinums(node.right);
    }


    public V removeMin(){
        Node retNode = mininums(root);

        root = removeMin(root);

        return retNode.value;
    }

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

    public V removeMax(){
        Node retNode = maxinums(root);

        root = removeMax(root);

        return retNode.value;
    }

    private Node removeMax(Node node){

        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMax(node.right);;

        return node;
    }


    public void remove(K key){
        root = remove(root , key);
    }

    private Node remove(Node node , K key){
        if(node == null){
            return null;
        }

        Node retNode = null;
        if(key.compareTo(node.key) > 0){
            node.right = remove(node.right , key);
            retNode =  node;
        }else if(key.compareTo(node.key) < 0){
            node.left = remove(node.left , key);
            retNode =  node;
        }else{
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                retNode =  rightNode;
            }

            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                retNode =  leftNode;
            }else{
                Node successor = mininums(node.right);
                successor.left = node.left;
//                successor.right = removeMin(node.right);
                successor.right = remove(node.right , successor.key);
                node.right = null;
                node.left = null;
                retNode = successor;
            }
        }


        if(retNode == null){
            return null;
        }

        // 重新计算数的高度
        retNode.height = Math.max(retNode.left.height , retNode.right.height) + 1;

        // 求数的平衡因子
        int balanceFactor = getBalanceFactor(retNode);

        // LL
        if(balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0){
            // 右旋转
            return rightRotate(retNode);
        }

        // RR
        if(balanceFactor < -1 && getBalanceFactor(retNode.right) >= 0){
            // 左旋转
            return leftRotate(retNode);
        }

        // LR
        if(balanceFactor > 1 && getBalanceFactor(retNode.left) <= 0){
            retNode.left = leftRotate(retNode.left);

            return rightRotate(retNode);
        }

        // RL
        if(balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0){
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }

        return retNode;
    }



}
