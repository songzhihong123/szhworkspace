package com.song.medium;

import java.util.HashSet;
import java.util.Set;

public class _3 {





    public int lengthOfLongestSubstring(String s) {

        int n = s.length();

        Set<Character> set = new HashSet<>();

        int ret = 0;
        int rIndex = -1;

        for (int i = 0; i < n; i++) {

            if(i != 0){
                set.remove(s.charAt(i));
            }

            while(rIndex + 1 < n && !set.contains(s.charAt(rIndex + 1))){
                set.add(s.charAt(rIndex + 1));
                rIndex ++;
            }

            ret = Math.max(ret , rIndex - i + 1);


        }


        return ret;
    }





    public static void main(String[] args){
        _3 obj = new _3();
        String s = "abcabcbb";
        System.out.println(obj.lengthOfLongestSubstring(s));
    }




}
