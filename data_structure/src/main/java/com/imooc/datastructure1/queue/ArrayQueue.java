package com.imooc.datastructure1.queue;

/**
 * @ClassName ArrayQueue
 * @Description ArrayQueue
 * @Author szh
 * @Date 2023年07月16日
 */
public class ArrayQueue<E> implements Queue<E>{

    private Array<E> array;

    public ArrayQueue(int capaticy){
        array = new Array<>(capaticy);
    }

    public ArrayQueue(){
        array = new Array<>();
    }


    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append(" front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");

        return res.toString();
    }


    public static void main(String[] args) {
        com.imooc.datastructure.queue.ArrayQueue<Integer> queue = new com.imooc.datastructure.queue.ArrayQueue<>();

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
