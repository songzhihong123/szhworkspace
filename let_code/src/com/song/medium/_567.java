package com.song.medium;

import java.util.Arrays;

/**
 * Created by Zhihong Song on 2021/2/14 10:16
 */

public class _567 {

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n > m){
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; i++) {
            cnt1[s1.charAt(i) - 'a'] ++;
            cnt2[s2.charAt(i) - 'a'] ++;
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = n; i < m; i++) {
            cnt2[s2.charAt(i) - 'a'] ++;
            cnt2[s2.charAt(i - n) - 'a'] --;
            if(Arrays.equals(cnt1,cnt2)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){
        _567 obj = new _567();
        String s1 =  "ab";
        String s2 = "eidbaooo";
        System.out.println(obj.checkInclusion(s1, s2));
    }


}
