package com.song;

import java.util.ArrayList;

public class RBTree<K extends Comparable<K>,V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            color = RED;
        }
    }

    private Node root;
    private int size;

    public RBTree(){
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isRed(Node node){
        if(node == null)
            return BLACK;
        return node.color;
    }

    //向红黑树中添加新的元素e
    public void add(K key, V value) {
        root = add(root,key,value);
        root.color = BLACK;
    }

    //   node                     x
    //  /   \     左旋转         /  \
    // T1   x   --------->   node   T3
    //     / \              /   \
    //    T2 T3            T1   T2
    private Node leftRotate(Node node){
        Node x = node.right;
        //左旋转
        node.right = x.left;
        x.left = node;
        //节点颜色
        x.color = node.color;
        node.color = RED;

        return x;
    }

    //     node                   x
    //    /   \     右旋转       /  \
    //   x    T2   ------->   y   node
    //  / \                       /  \
    // y  T1                     T1  T2
    private Node rightRotate(Node node){
        Node x = node.left;
        //右旋转
        node.left = x.right;
        x.right = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }

    //颜色翻转
    private void filpColors(Node node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    //向以node为根的红黑树中插入元素(key,value),递归算法
    //返回插入新节点后红黑树的根
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

        //红黑树中的平衡维护
        if(isRed(node.right) && !isRed(node.left))
            node = leftRotate(node);

        if(isRed(node.left) && isRed(node.left.left))
            node = rightRotate(node);

        if(isRed(node.left) && isRed(node.right))
            filpColors(node);



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
        if(key.compareTo(node.key) < 0){
            node.left = remove(node.left,key);
            return node;
        }else if(key.compareTo(node.key) > 0){
            node.right = remove(node.right,key);
            return node;
        }else{ //key.compareTo(node.key) == 0
            //三种情况：
            //1.只有左子树
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            //2.只有右子树
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            //3.左子树有右子树都有；找到当前节点的后继节点来代替当前节点
            Node minimum = minimum(node.left);
            minimum.left = node.left;
            minimum.right = removeMin(node.right);
            node.left = null;
            node.right = null;
            return minimum;
        }
    }



    //以node为根的二分搜索树最小值所在的节点
    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

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


    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt",words)){
            System.out.println("Total words: "+words.size());
            RBTree<String,Integer> map = new RBTree<String, Integer>();
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

        }
    }


}
