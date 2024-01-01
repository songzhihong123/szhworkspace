package com.imooc.datastructure1.avl;


import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @ClassName AVLTree
 * @Description AVLTree
 * @Author szh
 * @Date 2024年01月01日
 */
public class AVLTree<K extends Comparable<K> , V> {

    /**
     *
     * 平衡二叉树：对于任意一个节点，左子树和右子树的高度差不能超过1
     * 平衡因子：左子树和右子树的高度差
     *
     */

    private class Node{
        public K key;

        public V value;

        public int height;
        public Node left , right;

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

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // 判断该二叉树是否是一颗二分搜索树
    public boolean isBST(){
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root , keys);

        for(int i = 1 ; i < keys.size() ; i++){
            if(keys.get(i).compareTo(keys.get(i - 1)) < 0){
                return false;
            }
        }
        return true;
    }


    private void inOrder(Node node , ArrayList<K> keys){
        if(node == null){
            return;
        }
        inOrder(node.left , keys);
        keys.add(node.key);
        inOrder(node.right , keys);
    }

    // 判断该二叉树是否是一颗平衡二叉树
    public boolean isBalanced(){

        return isBalanced(root);
    }

    // 判断以Node为根的二叉树是否是一颗平衡二叉树 ， 递归算法
    private boolean isBalanced(Node node){
        if(node == null){
            return true;
        }

        if(Math.abs(getBalanceFactor(node)) > 1){
            return false;
        }

        return isBalanced(node.left) &&  isBalanced(node.right);
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




    // 向二分搜索树中添加新的元素（key , value）
    public void add(K key , V value){
        root = add(root , key , value);
    }

    // 向一个根结点为node的树中添加元素（key , value）
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node , K key , V value){
        if(node == null){
            size ++;
            return new Node(key , value);
        }
        if(key.compareTo(node.key) < 0){
            node.left = add(node.left , key , value);
        }else if(key.compareTo(node.key) > 0){
            node.right = add(node.right , key , value);
        }else{
            node.value = value;
        }

        // 更新height
        node.height = 1 + Math.max(getHeight(node.left) , getHeight(node.right));

        // 计算平衡因子
        int balanceFactor = getBalanceFactor(node);

        // 平衡因子大于1表示当前节点不平衡了
//        if(Math.abs(balanceFactor) > 1){
//            System.out.println("unbalanced: " + balanceFactor);
//        }

        // 平衡保护 LL
        if(balanceFactor > 1 && getBalanceFactor(node.left) >= 0){
            return rightRotate(node);
        }
        // 平衡保护 RR
        if(balanceFactor < -1 && getBalanceFactor(node.right) <= 0){
            return leftRotate(node);
        }
        // 平衡保护 LR
        // 对左子树左旋转之后转化为 LL
        if(balanceFactor > 1 && getBalanceFactor(node.left) < 0){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // 平衡保护 RL
        // 对右子树右旋转之后转化为RR
        if(balanceFactor < -1 && getBalanceFactor(node.right) > 0){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

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

        // 向右旋转的过程
        x.right = y;
        y.left = T3;

        // 更新height , 注意顺序
        y.height = Math.max(getHeight(y.right) , getHeight(y.left)) + 1;
        x.height = Math.max(getHeight(x.right) , getHeight(x.left)) + 1;

        return x;
    }


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

        // 向右旋转的过程
        x.left = y;
        y.right = T2;

        // 更新height , 注意顺序
        y.height = Math.max(getHeight(y.right) , getHeight(y.left)) + 1;
        x.height = Math.max(getHeight(x.right) , getHeight(x.left)) + 1;

        return x;
    }



    public V get(K key){
        Node node = getNode(root, key);

        return node == null ? null : node.value;
    }

    public boolean contains(K key){

        return get(key) != null;
    }

    private Node getNode(Node node , K key){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key) > 0){
            return getNode(node.right , key);
        }else if(key.compareTo(node.key) < 0){
            return getNode(node.left , key);
        }else{
            return node;
        }
    }



    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }

        return minimum(node.left);
    }


    private Node maximum(Node node){
        if(node.right == null){
            return node;
        }
        return maximum(node.right);
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
    public void remove(K key){
        root = remove(root , key);
    }


    // 删除以node为根的二分搜素树中值为e的节点
    // 返回删除节点后新的二分搜索树的根
    private Node remove(Node node , K key){
        if(node == null){
            return null;
        }

        Node retNode;

        if(key.compareTo(node.key) < 0){
            node.left = remove(node.left , key);
            retNode = node;
        }else if(key.compareTo(node.key) > 0){
            node.right = remove(node.right , key);
            retNode = node;
        }else{
            // 待删除的节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                retNode = rightNode;
            }
            //待删除节点的右子树为空的情况
            else if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                retNode = leftNode;
            }
            else {// 待删除节点的左右子树均不为空的时候

                // 找到当前节点的后继节点作为新节点
                Node successor = minimum(node.right);
//            successor.right = removeMin(node.right);
                successor.right = remove(node.right, successor.key);

                successor.left = node.left;
                // node节点与之前的树脱离关系
                node.left = null;
                node.right = null;
                retNode = successor;
            }
        }

        if(retNode == null){
            return null;
        }

        // 更新height
        retNode.height = 1 + Math.max(getHeight(retNode.left) , getHeight(retNode.right));

        // 计算平衡因子
        int balanceFactor = getBalanceFactor(retNode);

        // 平衡保护 LL
        if(balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0){
            return rightRotate(retNode);
        }
        // 平衡保护 RR
        if(balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0){
            return leftRotate(retNode);
        }
        // 平衡保护 LR
        // 对左子树左旋转之后转化为 LL
        if(balanceFactor > 1 && getBalanceFactor(retNode.left) < 0){
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }
        // 平衡保护 RL
        // 对右子树右旋转之后转化为RR
        if(balanceFactor < -1 && getBalanceFactor(retNode.right) > 0){
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }

        return retNode;
    }



}
