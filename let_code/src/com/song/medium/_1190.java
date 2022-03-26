package com.song.medium;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: szh
 * @create: 2021-05-27 15:48
 **/
public class _1190 {

    //给出一个字符串 s（仅含有小写英文字母和括号）。
    //请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。

    public String reverseParentheses(String s) {
        // "(ed(et(oc))el)"
        Deque<String> stack = new LinkedList<>();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '('){
                stack.push(buffer.toString());
                buffer.setLength(0);
            }else if(c == ')'){
                buffer.reverse();
                buffer.insert(0,stack.pop());
            }else {
                buffer.append(c);
            }
        }

        return buffer.toString();
    }


    public String reverseParentheses1(String s) {
        // "(ed(et(oc))el)"

        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '('){
                stack.push(i);
            }else if(s.charAt(i) == ')'){
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuffer sb = new StringBuffer();

        int index = 0;
        int step = 1;
        while (index < n){
            if(s.charAt(index) == '(' || s.charAt(index) == ')'){
                index = pair[index];
                step = -step;
            }else {
                sb.append(s.charAt(index));
            }
            index += step;
        }

        return sb.toString();
    }



    public static void main(String[] args){
        _1190 obj = new _1190();
        String s = "(ed(et(oc))el)";
        System.out.println(obj.reverseParentheses1(s));
    }

}
