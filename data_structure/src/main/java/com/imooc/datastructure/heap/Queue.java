package com.imooc.datastructure.heap;

public interface Queue<E> {


    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();

}
