package com.letcode.szh.sort;

/**
 * @ClassName BST
 * @Description 二分搜索树
 * @Author szh
 * @Date 2023年12月31日
 */
public class BST<E extends Comparable<E>> {

    public class Node{
        E e;
        Node left ;
        Node right;

        Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
        }

    }

    private Node root;

    private int size;

    public BST(E e){
        root = new Node(e);
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
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

        return node;
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


    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);

    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);

    }

    public void afterOrder(){
        afterOrder(root);
    }

    private void afterOrder(Node node){
        if(node == null){
            return;
        }
        afterOrder(node.left);
        afterOrder(node.right);
        System.out.println(node.e);

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

        if(e.compareTo(node.e) > 0){
            node.right = remove(node.right , e);
            return node;
        }else if(e.compareTo(node.e) < 0){
            node.left = remove(node.left , e);
            return node;
        }else{
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 即有左子树 ， 又有右子树 ， 找到当前节点的后继节点作为当前节点的替代节点
            // 后继节点为右子树的最小节点
            Node newNode = minimum(node.right);
            newNode.right = removeMin(node.right);
            newNode.left = node.left;

            node.left = null;
            node.right = null;

            return newNode;
        }

    }









}
