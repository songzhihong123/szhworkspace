package com.imooc.datastructure1.stack;

/**
 * @ClassName Stack
 * @Description TODO
 * @Author szh
 * @Date 2023年07月16日
 */
public interface Stack<E> {


    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();


}
