package com.imooc.datastructure1.stack;

/**
 * @ClassName Main
 * @Description Main
 * @Author szh
 * @Date 2023年07月16日
 */
public class Main {

    public static void main(String[] args) {

        ArrayStack<Integer> stack  = new ArrayStack<>();

        for (int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);

    }

}
