package com.song.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zhihong Song on 2021/4/9 16:44
 */

public class _Offer_48 {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        Map<Character,Integer> map = new HashMap<>();
        int res = 0;
        int tmp = 0;
        for (int j = 0; j < len; j++) {
            Integer i = map.getOrDefault(s.charAt(j), -1);
            map.put(s.charAt(j),j);
            if(tmp < j - i){
                tmp += 1;
            }else {
                tmp = j - i;
            }
            res = Math.max(res,tmp);
        }
        return res;
    }



    public static void main(String[] args){
        _Offer_48 obj = new _Offer_48();
        String s = "pwwkew";
        System.out.println(obj.lengthOfLongestSubstring(s));
    }




}
