package com.song.simple;

/**
 * Created by Zhihong Song on 2021/1/20 15:50
 */

public class _Offer58_II {

    public String reverseLeftWords(String s, int n) {
        String part1 = s.substring(0, n);
        String part2 = s.substring(n, s.length());
        return part2 + part1;
    }

    public String reverseLeftWords1(String s, int n) {

        String result = "";

        for (int i = n; i < s.length(); i++) {
            result += s.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            result += s.charAt(i);
        }

        return result;
    }

    public static void main(String[] args) {
        _Offer58_II obj = new _Offer58_II();
        String s = "abcdefg";
        System.out.println(obj.reverseLeftWords1(s, 2));
    }


}
