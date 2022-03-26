package com.song.simple;

import java.util.ArrayList;
import java.util.List;

public class _830 {

    public static void main(String[] args) {
        String s = "abbxxxxzyyy";
        List<List<Integer>> lists = largeGroupPositions(s);
        lists.forEach(System.out::print);
    }

    public  static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        if(s == null || s.trim().length() == 0){
            return result;
        }
        s += "A";
        int begin = 0;
        for(int i = 1 ; i < s.length() ; i ++){
            if(s.charAt(i) != s.charAt(i-1)){
                if(i - begin >= 3){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(begin);
                    temp.add(i-1);
                    result.add(temp);
                }
                begin = i;
            }
        }
        return result;
    }

}
