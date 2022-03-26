package com.song;
public class Solution {
    public boolean isValid(String s){
        Stack<Character> stack = new ArrayStack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }else{
                    Character pop = stack.pop();
                    if(c == ')' && pop != '(')
                        return false;
                    if(c == ']' && pop != '[')
                        return false;
                    if(c == '}' && pop != '{')
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("{}()[]"));
    }

}
