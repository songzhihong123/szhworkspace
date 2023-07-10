package com.imooc.datastructure1.array;

/**
 * @ClassName Main
 * @Description Main
 * @Author szh
 * @Date 2023年07月09日
 */
public class Main {

    public static void main(String[] args){
        Array<Integer> arr = new Array<>();
        for (int i = 0 ; i < 10 ; i++){
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1 , 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

    }


}
