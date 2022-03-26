package com.imooc.datastructure.heap;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    // 将一个无序数组整理成一个最大堆
    // 从最后一个非叶子节点执行元素下沉的操作
    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1) ; i >=0 ; i--) {
            siftDown(i);
        }
    }



    // 返回堆中的元素个数
    public int getSize(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    // 返回完全二叉树的数据表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index){
        if(index == 0){
            throw new IllegalArgumentException("index-0 doesn'n have parent");
        }
        return (index-1) / 2;
    }

    // 返回完全二叉树的数据表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return index * 2 + 1;
    }

    // 返回完全二叉树的数据表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return index * 2 + 2;
    }

    //项堆中添加元素
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    // 元素上浮
    private void siftUp(int k){
        while( k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            data.swap(k , parent(k));
            k = parent(k);
        }
    }

    // 看堆中最大的元素
    public E findMax(){
        if (data.getSize() == 0){
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    //取出堆中最大的元素
    public E extractMax(){
        E ret = findMax();

        // 1.将完全二叉树的第一个节点和最后一个节点交换位置
        data.swap(0 , data.getSize() - 1);
        data.removeLast();
        // 2.执行一下元素下沉的操作
        siftDown(0);

        return ret;
    }

    // 元素下沉
    private void siftDown(int k){

        while(leftChild(k) < data.getSize()){
            int j = leftChild(k);
            if(j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0){
                j = rightChild(k);
                // data[j] 是 leftChild 和 rightChild 中的最大值
            }
            if(data.get(k).compareTo(data.get(j)) >= 0){
                break;
            }
            data.swap(k , j);
            k = j;
        }

    }


    // 取出堆中的最大元素，并且替换成元素e
    public E replace(E e){
        E ret = findMax();
        data.set(0 , e);
        siftDown(0);
        return ret;
    }









}
