package com.song;

import java.util.ArrayList;
import java.util.List;

public class AVLTree<K extends Comparable<K>,V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key, V value) {
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

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //判断该二叉树是否是一颗二分搜索树.
    public boolean isBST(){
        List<K> keys = new ArrayList<>();
        inOrder(root,keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i-1).compareTo(keys.get(i)) > 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 中序遍历.
     */
    private void inOrder(Node node,List<K> keys){
        if(node == null){
            return;
        }
        inOrder(node.left,keys);
        keys.add(node.key);
        inOrder(node.right,keys);
    }

    //判断该二叉树是不是一颗平衡二叉树
    public boolean isBlanced(){
        return isBlanced(root);
    }

    //判断以Node为根的二叉树是否是一颗平衡二叉树，递归算法
    private boolean isBlanced(Node node){
        if(node == null){
            return true;
        }

        int balanceFacor = getBalanceFacor(node);
        if (Math.abs(balanceFacor)>1)
            return false;
        return isBlanced(node.left) && isBlanced(node.right);
    }

    //传入一个节点，返回这个节点的高度值
    private int getHeight(Node node){
        if(node == null)
            return 0;
        return node.height;
    }

    //获取节点node的平衡因子
    private int getBalanceFacor(Node node){
        if(node == null){
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    /**
     * 维护平衡时的右旋转的操作.
     * @param y  添加一个节点之后y节点开始是去了平衡性
     * @return   返回右旋转之后的根节点
     */
    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    private Node rightRotate(Node y){
        Node x = y.left;
        Node T3 = x.right;

        //向右旋转的过程
        x.right = y;
        y.left = T3;

        //更新hright
        y.height = Math.max(getHeight(y.left),getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left),getHeight(x.right)) + 1;

        return x;
    }

    /**
     * 维护平衡时的左旋转的操作.
     * @param y  添加一个节点之后y节点开始是去了平衡性
     * @return   返回左旋转之后的根节点
     */
    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node leftRotate(Node y){

        Node x = y.right;
        Node T2 = x.left;

        //向左旋转的过程
        x.left = y;
        y.right = T2;

        //更新hright
        y.height = Math.max(getHeight(y.left),getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left),getHeight(x.right)) + 1;

        return x;
    }


    //向二分搜索树中添加新的元素e
    public void add(K key, V value) {
        root = add(root,key,value);
    }

    //向以node为根的二分搜索树中插入元素(key,value),递归算法
    //返回插入新节点后二分搜索树的根
    private Node add(Node node ,K key,V value){
        if(node == null){
            size ++;
            return new Node(key, value);
        }
        if(key.compareTo(node.key) < 0){
            node.left = add(node.left,key,value);
        }else if(key.compareTo(node.key) > 0){
            node.right = add(node.right,key,value);
        }else{ //key.compareTo(node.key) == 0
            node.value = value;
        }

        //更新height值
        node.height = Math.max(getHeight(node.left),getHeight(node.right)) + 1;
        int balanceFacor = getBalanceFacor(node);
//        if(Math.abs(balanceFacor) > 1){
//            System.out.println("unbalanced : "+balanceFacor);
//        }

        //平衡的维护
        //在节点的左侧的左侧添加了一个节点
        // LL
        if(balanceFacor > 1 && getBalanceFacor(node.left) >= 0){
            return  rightRotate(node);
        }
        // RR
        if(balanceFacor < -1 && getBalanceFacor(node.right) <= 0){
            return leftRotate(node);
        }
        // LR
        if(balanceFacor > 1 && getBalanceFacor(node.left) < 0){
            //先对节点的左子树进行一次左旋转
            //然后在对当前节点做一次右旋转
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // RL
        if(balanceFacor < -1 && getBalanceFacor(node.right) > 0){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    //返回以node为节点的二分搜索树中，key所在的节点
    private Node getNode(Node node,K key){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key) == 0){
            return node;
        }else if(key.compareTo(node.key) < 0){
            return getNode(node.left,key);
        }else{//(key.compareTo(node.key) > 0)
            return  getNode(node.right,key);
        }
    }

    public boolean contains(K key) {
        return  getNode(root,key) != null;
    }

    public V get(K key) {
        Node node = getNode(root, key);
        return node != null ? node.value : null;
    }

    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if(node == null){
            throw new IllegalArgumentException(key + "doesn't exist!");
        }
        node.value = newValue;
    }

    public V remove(K key) {
        Node node = getNode(root,key);
        if(node != null){
            root = remove(root,key);
            return node.value;
        }
        return null;
    }


    //删除掉以node为根的二分搜索树中键为为key的节点，递归算法
    //返回删除节点后新的二分搜索树的根节点
    private Node remove(Node node , K key){
        if(node == null){
            return null;
        }
        Node retNode;
        if(key.compareTo(node.key) < 0){
            node.left = remove(node.left,key);
            retNode =  node;
        }else if(key.compareTo(node.key) > 0){
            node.right = remove(node.right,key);
            retNode =  node;
        }else{ //key.compareTo(node.key) == 0
            //三种情况：
            //1.只有左子树
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                retNode = leftNode;
            }else if(node.left == null){
                //2.只有右子树
                Node rightNode = node.right;
                node.right = null;
                size --;
                retNode = rightNode;
            } else {
                //3.左子树有右子树都有；找到当前节点的后继节点来代替当前节点
                Node successor = minimum(node.right);
//                successor.right = removeMin(node.right);
                successor.right = remove(node.right,successor.key);
                successor.left = node.left;
                node.left = node.right = null;
                retNode =  successor;
            }
        }

        if(retNode == null)
            return retNode;

        //更新height值
        retNode.height = Math.max(getHeight(retNode.left),getHeight(retNode.right)) + 1;
        int balanceFacor = getBalanceFacor(retNode);
//        if(Math.abs(balanceFacor) > 1){
//            System.out.println("unbalanced : "+balanceFacor);
//        }

        //平衡的维护
        // LL
        if(balanceFacor > 1 && getBalanceFacor(retNode.left) >= 0){
            return  rightRotate(retNode);
        }
        // RR
        if(balanceFacor < -1 && getBalanceFacor(retNode.right) <= 0){
            return leftRotate(retNode);
        }
        // LR
        if(balanceFacor > 1 && getBalanceFacor(retNode.left) < 0){
            //先对节点的左子树进行一次左旋转
            //然后在对当前节点做一次右旋转
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }
        // RL
        if(balanceFacor < -1 && getBalanceFacor(retNode.right) > 0){
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }

        return retNode;
    }



    //以node为根的二分搜索树最小值所在的节点
    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    /*
    //删除掉以node为根的二分搜索树中的最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }
    */

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt",words)){
            System.out.println("Total words: "+words.size());
            AVLTree<String,Integer> map = new AVLTree<>();
            for (String word: words) {
                if(map.contains(word)){
                    map.set(word,map.get(word)+1);
                }else{
                    map.add(word,1);
                }
            }
            System.out.println("Total different words :" + map.getSize());
            System.out.println("Freqency of PRIDE: " + map.get("pride"));
            System.out.println("Freqency of PREJUDICE: " + map.get("prejudice"));
            System.out.println("is BST : " + map.isBST());
            System.out.println("is isBlanced : " + map.isBlanced());

            for (String word: words) {
                map.remove(word);
                if (!map.isBST() || !map.isBlanced())
                    throw new RuntimeException("Error");
            }

        }
        System.out.println();
    }
}
