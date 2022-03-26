package com.song.medium;

import java.util.*;

/**
 * Created by Zhihong Song on 2021/4/2 11:18
 */

public class _1006 {


    public int clumsy2(int N){
        if (N == 1) {
            return 1;
        } else if (N == 2) {
            return 2;
        } else if (N == 3) {
            return 6;
        } else if (N == 4) {
            return 7;
        }

        if (N % 4 == 0) {
            return N + 1;
        } else if (N % 4 <= 2) {
            return N + 2;
        } else {
            return N - 1;
        }
    }


    public int clumsy1(int n) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(n);
        n--;
        int index = 0;
        while (n > 0){
            if(index % 4 == 0){
                stack.push(stack.pop() * n);
            }else if(index % 4 == 1){
                stack.push(stack.pop() / n);
            }else if(index % 4 == 2){
                stack.push(n);
            }else if(index % 4 == 3){
                stack.push(-n);
            }
            index ++;
            n --;
        }
        int sum = 0;
        while (!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }





    public int clumsy(int n) {
        if(n ==0 || n == 1){
            return n;
        }
        Deque<String> stack = new LinkedList<>();
        Deque<String> swapstack = new LinkedList<>();
        String[] symbols = {"*","/","+","-"};
        int res = n - 1;
        int count = 0;
        stack.push(String.valueOf(n));
        while(res != 0){
            int index = count % symbols.length;
            String symbol = symbols[index];
            stack.push(symbol);
            count ++;
            stack.push(String.valueOf(res));
            res -= 1;
        }
        while(!stack.isEmpty()){
            swapstack.push(stack.pop());
        }
        stack.push(swapstack.pop());
        while (!swapstack.isEmpty()){
            String pop = swapstack.pop();
            switch (pop){
                case "*":
                    stack.push(String.valueOf(Integer.parseInt(stack.pop()) * Integer.parseInt(swapstack.pop())));
                    break;
                case "/":
                    stack.push(String.valueOf(Integer.parseInt(stack.pop()) / Integer.parseInt(swapstack.pop())));
                    break;
                case "+":
                    stack.push(pop);
                    stack.push(swapstack.pop());
                    break;
                case "-":
                    stack.push(pop);
                    stack.push(swapstack.pop());
                    break;
            }
        }

        while(!stack.isEmpty()){
            swapstack.push(stack.pop());
        }
        int result = Integer.parseInt(swapstack.pop());
        while(!swapstack.isEmpty()){
            String symbol = swapstack.pop();
            switch (symbol) {
                case "+":
                    result += Integer.parseInt(swapstack.pop());
                    break;
                case "-":
                    result -= Integer.parseInt(swapstack.pop());
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int n = 4;
        _1006 obj = new _1006();
        System.out.println(obj.clumsy2(n));
    }



}
