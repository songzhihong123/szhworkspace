package com.imooc.datastructure1.linkedlist;

/**
 * @ClassName Main
 * @Description Main
 * @Author szh
 * @Date 2023年07月30日
 */
public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0 ; i < 5 ; i++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2 , 666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

    }

}
