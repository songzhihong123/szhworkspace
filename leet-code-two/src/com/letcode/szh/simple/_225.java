package com.letcode.szh.simple;

import java.util.ArrayDeque;
import java.util.List;

/**
 * @ClassName _225
 * @Description _225
 * @Author szh
 * @Date 2023年12月20日
 */
public class _225 {



    public static void main(String[] args) {

        MyStack1 myStack = new MyStack1();
        myStack.push(1);
        int pop = myStack.pop();
        boolean empty = myStack.empty();

        System.out.println(" pop: " + pop + " empty: " + empty);

    }



}

class MyStack {

    public  ArrayDeque<Integer> queue1 = null;

    public  ArrayDeque<Integer> queue2 = null;

    public MyStack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    // 将元素 x 压入栈顶
    public void push(int x) {
        while (!queue1.isEmpty()){
            queue2.add(queue1.pop());
        }
        queue1.add(x);
    }

    // 移除并返回栈顶元素
    public int pop() {
        int result = queue1.pop();
        while (!queue2.isEmpty()){
            queue1.add(queue2.pop());
        }

        while (!queue1.isEmpty() && queue1.size() != 1){
            queue2.add(queue1.pop());
        }

        return result;
    }

    // 返回栈顶元素
    public int top() {

        return !queue1.isEmpty() ? queue1.peek() : -1;
    }

    // 如果栈是空的，返回 true , 否则返回false
    public boolean empty() {

        return queue1.isEmpty() && queue2.isEmpty();
    }
}


class MyStack1 {

    public  ArrayDeque<Integer> queue = null;

    public MyStack1() {
        queue = new ArrayDeque<>();
    }

    // 将元素 x 压入栈顶
    public void push(int x) {
        int size = queue.size();
        queue.add(x);
        for (int i = 0 ; i < size ; i ++){
            queue.add(queue.pop());
        }

    }

    // 移除并返回栈顶元素
    public int pop() {

        return queue.pop();
    }

    // 返回栈顶元素
    public int top() {

        return !queue.isEmpty() ? queue.peek() : -1;
    }

    // 如果栈是空的，返回 true , 否则返回false
    public boolean empty() {

        return queue.isEmpty();
    }
}
