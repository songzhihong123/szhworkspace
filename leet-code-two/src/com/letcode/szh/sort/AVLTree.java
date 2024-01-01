package com.letcode.szh.sort;

import java.util.ArrayList;

/**
 * @ClassName AVLTree
 * @Description 二叉平衡树
 * @Author szh
 * @Date 2024年01月01日
 */
public class AVLTree<E extends Comparable<E>> {


    public class Node{
        E e;
        Node left ;
        Node right;

        int height;

        Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
            this.height = 1;
        }

    }

    private Node root;

    private int size;

    public AVLTree(E e){
        root = new Node(e);
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // 判断当前树是不是二分搜索树
    public boolean isBST(){

        ArrayList<E> list = new ArrayList<>();
        inOrder(root , list);

        for(int i = 1 ; i < list.size() ; i ++){
            if(list.get(i).compareTo(list.get(i - 1)) < 0){
                return false;
            }
        }
        return true;
    }

    // 二分搜索树的中序遍历
    private void inOrder(Node node , ArrayList<E> list){
        if(node == null){
            return;
        }
        inOrder(node.left , list);
        list.add(node.e);
        inOrder(node.right , list);
    }

    //判断当前树是不是平衡二叉树
    //所有节点的平衡因子小于1
    public boolean isAvl(){
        return isAvl(root);
    }

    // 判断以node为节点的二叉树是不是平衡二叉树
    private boolean isAvl(Node node){
        if(node == null){
            return true;
        }

        if(Math.abs(getBalance(node)) > 1){
            return false;
        }

        return isAvl(node.left) && isAvl(node.right);
    }


    public int getHeight(Node node){
        return node.height;
    }

    public int getBalance(Node node){
        return getHeight(node.left) - getHeight(node.right);
    }


    public void add(E e){
        root = add(root , e);
    }

    // 在以node为根的二分搜索树中插入元素为e的节点
    // 返回元素e新的二分搜索树的根
    private Node add(Node node , E e){
        if(node == null){
            size ++;
            return new Node(e);
        }
        if(e.compareTo(node.e) > 0){
            node.right = add(node.right , e);
        }else if(e.compareTo(node.e) < 0){
            node.left = add(node.left , e);
        }

        // 重新计算node的高度
        node.height = Math.max(getHeight(node.left) , getHeight(node.right)) + 1;

        // 获取node的平衡因子
        int balance = getBalance(node);

        //维持平衡
        // LL , 需求进行右旋转
        if(balance > 1 && getBalance(node.left) >= 0){
            return rightRoute(node);
        }

        // RR , 需求进行左旋转
        if(balance < -1 && getBalance(node.right) <= 0){

            return leftRoute(node);
        }

        //LR
        if(balance > 1 && getBalance(node.left) < 0){
            node.left = leftRoute(node.left);

            return rightRoute(node);
        }

        ///RL
        if(balance < -1 && getBalance(node.right) >= 0){
            node.right = leftRoute(node.right);
            return leftRoute(node);
        }



        return node;
    }


    // 右旋转 ， 返回旋转之后的根节点
    public Node rightRoute(Node y){

        Node x = y.left;
        Node t = x.right;

        // 旋转
        x.right = y;
        y.left = t;

        //重新计算高度
        y.height = Math.max(getHeight(y.left) , getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left) , getHeight(x.right)) + 1;

        return x;
    }

    // 左旋转 ， 返回旋转之后的根节点
    public Node leftRoute(Node y){

        Node x = y.right;
        Node t = x.left;

        // 旋转
        x.left = y;
        y.right = t;

        //重新计算高度
        y.height = Math.max(getHeight(y.left) , getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left) , getHeight(x.right)) + 1;

        return x;
    }






    public boolean contains(E e){

        return contains(root , e);
    }

    // 在以node为根的二分搜索树中返回是否包含元素为e的节点
    private boolean contains(Node node , E e){
        if(node == null){
            return false;
        }

        if(e.compareTo(node.e) > 0){
            return contains(node.right , e);
        }else if(e.compareTo(node.e) < 0){
            return contains(node.left , e);
        }else{
            return true;
        }
    }



    // 找最小值
    public E minimum(){
        return minimum(root).e;
    }

    // 找到以node为根的二分搜索树的最小节点
    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }

        return minimum(node.left);
    }


    // 找最大值
    public E maximum(){
        return maximum(root).e;
    }

    // 找到以node为根的二分搜索树的最大节点
    private Node maximum(Node node){
        if(node.right == null){
            return node;
        }

        return minimum(node.right);
    }

    // 删除最小值
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    // 删除以node为根的最小节点
    // 返回删除节点之后的根节点
    public Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        return removeMin(node.left);
    }



    // 删除最大值
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    // 删除以node为根的最大节点
    // 返回删除节点之后的根节点
    public Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        return removeMax(node.right);
    }

    // 删除元素为e的节点
    public void remove(E e){
        root = remove(root , e);
    }

    // 删除以node为节点的二分搜索树中的元素为e的节点
    public Node remove(Node node , E e){
        if(node == null){
            return null;
        }

        Node retNode;

        if(e.compareTo(node.e) > 0){
            node.right = remove(node.right , e);
            retNode =  node;
        }else if(e.compareTo(node.e) < 0){
            node.left = remove(node.left , e);
            retNode = node;
        }else{
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                retNode = rightNode;
            }
            else if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                retNode = leftNode;
            }
            else{
                // 即有左子树 ， 又有右子树 ， 找到当前节点的后继节点作为当前节点的替代节点
                // 后继节点为右子树的最小节点
                Node newNode = minimum(node.right);
//                newNode.right = removeMin(node.right);
                newNode.right = remove(node.right , newNode.e);
                newNode.left = node.left;

                node.left = null;
                node.right = null;

                retNode =  newNode;
            }
        }

        if(retNode == null){
            return null;
        }


        // 重新计算node的高度
        retNode.height = Math.max(getHeight(retNode.left) , getHeight(retNode.right)) + 1;

        // 获取node的平衡因子
        int balance = getBalance(retNode);

        //维持平衡
        // LL , 需求进行右旋转
        if(balance > 1 && getBalance(retNode.left) >= 0){
            return rightRoute(retNode);
        }

        // RR , 需求进行左旋转
        if(balance < -1 && getBalance(retNode.right) <= 0){

            return leftRoute(retNode);
        }

        //LR
        if(balance > 1 && getBalance(retNode.left) < 0){
            retNode.left = leftRoute(retNode.left);

            return rightRoute(retNode);
        }

        ///RL
        if(balance < -1 && getBalance(retNode.right) >= 0){
            retNode.right = leftRoute(retNode.right);
            return leftRoute(retNode);
        }


        return retNode;
    }


}
