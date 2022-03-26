package com.imooc.datastructure.set;

import java.util.TreeSet;

public class _804 {

    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        TreeSet<String> set = new TreeSet<>();

        for(String word : words){
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                res.append(codes[word.charAt(i)- 'a']);
            }
            set.add(res.toString());
        }
        return set.size();
    }


    public static void main(String[] args){

        _804 obj = new _804();








    }







}
