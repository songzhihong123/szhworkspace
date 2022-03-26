package com.imooc.datastructure.stack;

public class LinkedStack<E> implements Stack<E> {

    private LinkedList<E> linkedList;

    public LinkedStack(){
        linkedList = new LinkedList<>();
    }

    @Override
    public int getSize(){
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty(){
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e){
        linkedList.addFirst(e);
    }

    @Override
    public E pop(){
        return linkedList.removeFirst();
    }

    @Override
    public E peek(){
        return linkedList.getFirst();
    }

    @Override
    public String toString(){

        StringBuilder builder = new StringBuilder();

        builder.append("Stack: top ");
        builder.append(linkedList);

        return builder.toString();
    }


    public static void main(String[] args){
        LinkedStack<Integer> arrayStack = new LinkedStack<>();

        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }

        arrayStack.pop();
        System.out.println(arrayStack);
    }


}
