package com.song.medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Zhihong Song on 2021/3/20 9:34
 */

public class _150 {


    /**
     *
     * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
     *
     */

    public int evalRPN(String[] tokens) {
        Stack<String> initStack = new Stack();
        int len = tokens.length;
        for (int i = len - 1; i >= 0; i--) {
            initStack.push(tokens[i]);
        }
        Stack<String> extStack = new Stack<>();
        int param1 = 0;
        int param2 = 0;
        while (!(extStack.empty() && initStack.size() == 1)){
            String pop = initStack.pop();
            switch (pop){
                case "+":
                     param1 = Integer.parseInt(extStack.pop());
                     param2 = Integer.parseInt(extStack.pop());
                    initStack.push(param2 + param1 + "");
                    break;
                case "-":
                     param1 = Integer.parseInt(extStack.pop());
                     param2 = Integer.parseInt(extStack.pop());
                    initStack.push(param2 - param1 + "");
                    break;
                case "*":
                     param1 = Integer.parseInt(extStack.pop());
                     param2 = Integer.parseInt(extStack.pop());
                    initStack.push(param2 * param1 + "");
                    break;
                case "/":
                     param1 = Integer.parseInt(extStack.pop());
                     param2 = Integer.parseInt(extStack.pop());
                    initStack.push(param2 / param1 + "");
                    break;
                 default:
                     extStack.push(pop);
            }

        }
            return Integer.parseInt(initStack.peek());
    }



    public int evalRPN1(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            if(isNumber(token)){
                stack.push(Integer.parseInt(tokens[i]));
            }else{
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token){
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                }


            }
        }
        return stack.peek();
    }

    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }



    public static void main(String[] args){
        String[] tokens = {"10"};
        _150 obj = new _150();
        System.out.println(obj.evalRPN1(tokens));
    }



}
