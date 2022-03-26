package com.imooc.datastructure.stack;

import java.util.Stack;


public class _20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(c == '[' || c == '(' || c == '{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    Character pop = stack.pop();
                    if(c == ')' && pop != '('){
                        return false;
                    }
                    if(c == ']' && pop != '['){
                        return false;
                    }
                    if(c == '}' && pop != '{'){
                        return false;
                    }
                }
            }

        }
        return stack.isEmpty();
    }



    public static void main(String[] args){

    }


}
