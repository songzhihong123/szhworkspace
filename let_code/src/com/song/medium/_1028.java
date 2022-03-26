package com.song.medium;

/**
 * Created by Zhihong Song on 2021/2/9 16:12
 */

public class _1028 {

    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int maxLen = 0;
        int left = 0;
        int right = 0;
        int add = 0;
        while (right < len){
            add += arr[right];
            while(add > maxCost){
                add -= arr[left];
                left++;
            }
            maxLen = Math.max(maxLen,right - left + 1);
            right ++;
        }
        return maxLen;
    }



    public static void main(String[] args){
        _1028 obj = new _1028();
        String s = "abcd";
        String t = "bcdf";
        int cost = 3;
        System.out.println(obj.equalSubstring(s, t, cost));
    }


}
