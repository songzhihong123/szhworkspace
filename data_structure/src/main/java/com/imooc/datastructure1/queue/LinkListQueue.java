package com.imooc.datastructure1.queue;

import com.imooc.datastructure.queue.LinkedListQueue;
import com.imooc.datastructure1.linkedlist.LinkedList;

/**
 * @ClassName LinkListQueue
 * @Description LinkListQueue
 * @Author szh
 * @Date 2023年08月06日
 */
public class LinkListQueue<E> implements Queue<E>{

    private class Node{
        public E e;
        public Node next;

        public Node(E e , Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e , null);
        }

        public Node(){
            this(null , null);
        }

        @Override
        public String toString(){
            return e.toString();
        }

    }

    private Node head , tail;
    private int size;

    public LinkListQueue(){
        head = null;
        tail = null;
        size = 0;
    }


    @Override
    public void enqueue(E e) {
        if(tail == null){
            tail = new Node(e);
            head = tail;
        }else{
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue form an empty queue");
        }
        Node tetNode = head;
        head = head.next;
        tetNode.next = null;
        if(head == null){
            tail = null;
        }
        size --;
        return tetNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue form an empty queue");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: front");
        for(Node cur = head; cur != null ; cur = cur.next){
            res.append(cur).append(" -> ");
        }
        res.append("NUll tail");
        return res.toString();
    }


    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();

        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }


    }


}
