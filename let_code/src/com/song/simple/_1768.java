package com.song.simple;

/**
 * @ClassName _1768
 * @Description TODO
 * @Author szh
 * @Date 2022年10月23日
 */
public class _1768 {



    public String mergeAlternately(String word1, String word2) {

        if(word1.length() == 0){
            return word2;
        }

        if(word2.length() == 0){
            return word1;
        }

        StringBuilder builder = new StringBuilder();

        int endIndex = Math.max(word1.length() , word2.length());


        for(int i = 0; i < endIndex; i++){
            if(i < word1.length()){
                builder.append(word1.charAt(i));
            }
            if(i < word2.length()){
                builder.append(word2.charAt(i));
            }
        }

        return builder.toString();
    }







    public static void main(String[] args){

        _1768 obj = new _1768();
        final String word1 = "abcd";
        final String word2 = "pq";
        System.out.println(obj.mergeAlternately(word1 , word2));
    }







}
