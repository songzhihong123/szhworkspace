package com.song;

import java.util.Random;

/**
 * 优缺点：
 *      数组栈： 数组栈需要不断的进行扩容缩容操作，比较耗时，而且还得考虑数组所占的空间大小
 *      链表栈：链表栈是不需要考虑空间的连续，而且对于栈操作的链表一直在操作链表的头结点，
 *                  时间复杂度是O(1),有极大的优点，缺点是，入栈操作需要往链表的头结点添加元素
 *                  的时候需要做 new  操作，如果数据量大话还不一定比数组栈的性能好.
 */
public class Main {

    private static double testStack(Stack<Integer> stack,int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime)/1000000000.0;

    }


    public static void main(String[] args) {
        int opCount = 100000;
	    ArrayStack<Integer> arrStack = new ArrayStack<Integer>();
        System.out.println(testStack(arrStack, opCount));

        LinckedListStack<Integer> linckedListStack = new LinckedListStack<Integer>();
        System.out.println(testStack(linckedListStack,opCount));

        //这个时间比较很复杂，因为LinkedListStack中包含更多的new操作

    }
}
