package com.letcode.szh.bilibili;

import java.util.Stack;

/**
 * @ClassName ReverseStackUsingRecursive
 * @Description ReverseStackUsingRecursive
 * @Author szh
 * @Date 2024年01月06日
 */
public class ReverseStackUsingRecursive {


    /*
    逆序一个栈
     */



    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        // 拿到栈底元素
        int i = f(stack);
        // 翻转其他元素
        reverse(stack);
        // 翻转之后拿到的的值放回去
        stack.push(i);
    }






    // 把栈底的值弹出来，然后返回
    public static int f(Stack<Integer> stack){
        Integer result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }else{
            int last = f(stack);
            stack.push(last);
            return last;
        }
    }


}
