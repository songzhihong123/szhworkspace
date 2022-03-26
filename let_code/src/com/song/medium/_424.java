package com.song.medium;

/**
 * Created by Zhihong Song on 2021/2/2 9:12
 */

public class _424 {

    public int characterReplacement(String s, int k) {
        // 用来窗口中每个字符出现的最大次数
        int[] enumCount = new int[26];
        int len = s.length();
        int left = 0 ;
        int right = 0;
        int tempMax = 0;

        while(right < len){
            enumCount[s.charAt(right) - 'A'] ++;
            tempMax = Math.max(tempMax,enumCount[s.charAt(right) - 'A']);
            if(right - left + 1 - tempMax > k){
                enumCount[s.charAt(left) - 'A'] --;
                left ++;
            }
            right ++;
        }
        return right - left;
    }



    public static void main(String[] args){
        _424 obj = new _424();
        String s = "AABABBA";
        int k = 1 ;
        System.out.println(obj.characterReplacement(s, k));

    }

}
