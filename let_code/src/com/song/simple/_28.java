package com.song.simple;/**
 * Created by Zhihong Song on 2021/4/20 8:39
 */

/**
 * @program: let_code
 * @description:
 * @author: szh
 * @create: 2021-04-20 08:39
 **/
public class _28 {

    public int strStr(String haystack, String needle) {
        int needleLen = needle.length();
        if(needleLen == 0){
            return 0;
        }
        char[] haystackChars = haystack.toCharArray();
        int haystackLen = haystackChars.length;
        int left = 0;
        int right = left + needleLen - 1;
        while(right < haystackLen){
            boolean flag = true;
            for (int i = left; i <= right; i++) {
                if (haystackChars[i] != needle.charAt(i - left)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return left;
            }
            left ++;
            right ++;
        }
        return -1;
    }

    public int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args){
        _28 obj = new _28();
        String haystack = "hello";
        String needle = "ll";
        System.out.println(obj.strStr(haystack, needle));
    }



}
