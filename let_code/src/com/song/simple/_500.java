package com.song.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _500 {

    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        String rowIndex = "12210111011122000010020202";
        for (int i = 0; i < words.length; i++) {
            boolean isValid = true;
            char idx = rowIndex.charAt(Character.toLowerCase(words[i].charAt(0)) - 'a');
            for (int j = 1; j < words[i].length(); j++) {
                if(rowIndex.charAt(Character.toLowerCase(words[i].charAt(j)) - 'a') != idx){
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                list.add(words[i]);
            }
        }

        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args){
        _500 obj = new _500();
        String[] words = {"Hello","Alaska","Dad","Peace"};

        Arrays.asList(obj.findWords(words)).forEach(System.out::println);


    }


}
