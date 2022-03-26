package com.song;

/**
 * 最大堆
 * @param <E>
 */
public class MaxHeap<E extends Comparable<E>> {


    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<E>(capacity);
    }

    public MaxHeap(){
        data = new Array<E>();
    }

    //返回堆中的元素个数
    public int size(){
        return data.getSize();
    }

    //返回一个布尔值，表示堆中是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    //返回在完全二叉树的数组中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index){
        if(index == 0)
                throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index-1)/2;
    }

    //返回在完全二叉树的数组中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return index * 2 + 1;
    }

    //返回在完全二叉树的数组中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return index * 2 + 2;
    }

    //向堆中添加元素
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize()-1);
    }

    //元素上浮  非递归写法
    private void siftUp(int k){
        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
                data.swap(k,parent(k));
                k = parent(k);
        }
    }
    private void siftu(int k){
        while(k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0){
            data.swap(k,parent(k));
            k = parent(k);
        }

    }


    //元素上浮 递归实现
    private void siftUp1(int k){
        if(k == 0 || data.get(k).compareTo(data.get(parent(k))) < 0){
            return;
        }
        data.swap(k,parent(k));
        siftUp1(parent(k));
    }

    //看堆中最大的元素
    public E findMax(){
        if (data.getSize() == 0){
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    //去除堆中最大的元素
    public E extractMax(){
        E e = findMax();
        data.swap(0,data.getSize()-1);
        data.removeLast();
        siftDown(0);
        return e;
    }

    //元素下沉 非递归写法
    private void siftDown(int k){
        while (leftChild(k) < data.getSize()){
           int j = leftChild(k);
           if(rightChild(k) < data.getSize() && data.get(leftChild(k)).compareTo(data.get(rightChild(k))) <= 0){
                j = rightChild(k);
           }
           if(data.get(k).compareTo(data.get(j)) >= 0){
                break;
           }
           data.swap(k,j);
           k = j;
        }
    }

    private void siftd(int k){
        while(leftChild(k) < data.getSize()){
            int j = leftChild(k);
            if(rightChild(k) < data.getSize() && data.get(leftChild(k)).compareTo(data.get(rightChild(k))) <= 0){
                j =rightChild(k);
            }
            if(data.get(k).compareTo(data.get(j)) >= 0){
                break;
            }
            data.swap(k,j);
            k = j;
        }
    }

    //元素下沉 递归写法
    private void siftDown1(int k){
        if(leftChild(k) >= data.getSize()){
            return;
        }
        int j = leftChild(k);
        if(rightChild(k) < data.getSize() && data.get(leftChild(k)).compareTo(data.get(rightChild(k))) <= 0){
            j =rightChild(k);
        }
        if(data.get(j).compareTo(data.get(k)) > 0){
            data.swap(k,j);
            siftDown1(j);
        }

    }
    //取出堆中的最大元素，并且替换成指定元素e
    public E replace(E e){
        E ret = findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }

    //将任意数组整理成堆的形状
    //原理：(比我们遍历这个数组然后一个一个添加元素要快的多)
        //从堆的第一个非叶子节点开始进行下沉操作
        //第一个非叶子节点的索引算法非常简单：
            //1. int res = (data.getSize() - 1)/2  --堆顶的索引从0开始
            //2. int res = (dataSize)/2            --堆顶的索引从1开始
    public MaxHeap(E[] arr){
        data = new Array<E>(arr);
        int index = parent(arr.length- 1);
        for (int i = index ; i >= 0; i--) {
            siftDown(i);
        }
    }

    //堆排序
    public void sort(E[] arr){
        for (int i = 0; i < arr.length; i++) {
            E e = extractMax();
            System.out.print(e + " ");
        }
    }
}
