package com.song;

public class Solution {

    public int firstUniqChar(String s){
        int[] ferq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ferq[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (ferq[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }




}
