package com.imooc.datastructure1.maxheap;


/**
 * @ClassName MaxHeap
 * @Description 最大堆
 * @Author szh
 * @Date 2023年12月31日
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }


    // 将任意数组整理成堆的形状
    // 找到最后一个非叶子节点 ， 遍历之前的元素，每个元素执行元素下沉操作
    public MaxHeap(E[] arr){
        data = new Array<>(arr);

        for(int i = parent(data.getSize() - 1) ; i >= 0 ; i++){
            siftDown(i);
        }
    }


    public int size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index){
        if(index == 0){
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }

        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中 , 一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return 2 * index + 1;
    }

    // 返回完全二叉树的数组表示中 , 一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return 2 * index + 2;
    }

    // 向堆中添加元素
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    // 元素上浮
    private void siftUp(int k){
        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            data.swap(k , parent(k));
            k = parent(k);
        }
    }

    // 看堆中最大元素
    public E findMax(){
        if(data.getSize() == 0){
            throw new IllegalArgumentException("Heap is empty.");
        }
        return data.get(0);
    }


    // 取出堆中最大的元素
    public E extractMax(){
        E ret = findMax();
        data.swap(0 , data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    // 元素下沉
    private void siftDown(int k){

        while (leftChild(k) < data.getSize()){

            int j = leftChild(k);
            if(j + 1 < data.getSize() &&
                            data.get(j + 1).compareTo(data.get(j)) > 0){
                j = rightChild(k);
            }
            // data[j] 是leftChild 和 rightChild 中的最大值
            if(data.get(k).compareTo(data.get(j)) < 0){
                data.swap(k , j);
                k = j;
            }else{
                break;
            }
        }

    }


    // 取出堆中最大元素， 并且替换成元素e
    public E replace(E e){
        E ret = findMax();
        data.set(0 , e);
        siftDown(0);
        return ret;
    }








}
