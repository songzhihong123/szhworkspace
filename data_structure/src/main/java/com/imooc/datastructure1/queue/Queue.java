package com.imooc.datastructure1.queue;

/**
 * @ClassName Queue
 * @Description Queue
 * @Author szh
 * @Date 2023年07月16日
 */
public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();

}
