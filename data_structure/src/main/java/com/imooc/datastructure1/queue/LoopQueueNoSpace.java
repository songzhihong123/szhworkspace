package com.imooc.datastructure1.queue;


/**
 * @ClassName LoopQueue
 * @Description LoopQueue
 * @Author szh
 * @Date 2023年07月16日
 */
public class LoopQueueNoSpace<E> implements Queue<E> {

    private E[] data;

    private int front;

    private int tail;

    private int size;

    public LoopQueueNoSpace(int capacity){
        data = (E[])new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueueNoSpace(){
        this(10);
    }

    public int getCapacity(){
        return data.length;
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
    public void enqueue(E e) {
        if(size == getCapacity()){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("dequeue failed , empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;

        if(size ==  getCapacity() /4  && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }

        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("empty queue.");
        }
        return data[front];
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];

        for (int i = 0 ; i < size ; i++){
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n" , size , getCapacity()));
        res.append("front [");
        for (int i = 0 ; i< size ; i++){
            res.append(data[(front + i) % data.length]);
            if((i + front + 1) % data.length != tail){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueueNoSpace<Integer> queue = new LoopQueueNoSpace<>();

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
