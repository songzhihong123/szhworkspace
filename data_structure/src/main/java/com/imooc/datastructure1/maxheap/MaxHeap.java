package com.imooc.datastructure1;

import java.util.ArrayList;

/**
 * @ClassName MaxHeap
 * @Description 最大堆
 * @Author szh
 * @Date 2023年12月31日
 */
public class MaxHeap<E extends Comparable<E>> {

    private ArrayList<E> data;

    public MaxHeap(int capacity){
        data = new ArrayList<>(capacity);
    }

    public MaxHeap(){
        data = new ArrayList<>();
    }

    public int size(){
        return data.size();
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










}
