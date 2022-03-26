package com.song.simple;

import java.util.Stack;

/**
 * Created by Zhihong Song on 2021/1/21 21:23
 */

public class _1221 {

    public int balancedStringSplit(String s) {
        int res = 0;
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'R'){
                n ++;
            }
            if(s.charAt(i) == 'L'){
                n --;
            }
            if(n == 0){
                res ++;
            }
        }
        return res;
    }

    public int balancedStringSplit1(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if(stack.size() != 0 && s.charAt(i) != stack.peek()){
                stack.pop();
                if(stack.size() == 0){
                    res ++;
                }
            }else {
                stack.push(s.charAt(i));
            }
        }
        return res;
    }



    public static void main(String[] args){
        _1221 obj = new _1221();
        String s = "RLLLLRRRLR";
        System.out.println(obj.balancedStringSplit(s));
    }


}
