package com.imooc.datastructure.queue;

public interface Queue<E> {


    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();




}
