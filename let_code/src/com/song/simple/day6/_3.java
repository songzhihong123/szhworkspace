package com.song.simple.day6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _3 {


    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int len = s.length();
        Set<Character> set = new HashSet<>();
        int rk = -1;
        for (int i = 0 ; i < len; i ++){
            if(i != 0){
                set.remove(s.charAt(i - 1));
            }
            while(rk + 1 < len && !set.contains(s.charAt(rk + 1))){
                set.add(s.charAt(rk + 1));
                rk ++;
            }
            ans = Math.max(ans , rk - i +1);
        }
        return ans;
    }




    public static void main(String[] args){
        _3 obj = new _3();
        String s = "abcabcbb";
        System.out.println(obj.lengthOfLongestSubstring(s));
    }





}
