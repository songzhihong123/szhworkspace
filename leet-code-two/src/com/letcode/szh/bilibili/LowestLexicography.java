package com.letcode.szh.bilibili;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName LowestLexicography
 * @Description LowestLexicography 贪心， 求最小字典序
 * @Author szh
 * @Date 2024年01月05日
 */
public class LowestLexicography {

    public static class MyComparator implements Comparator<String>{

        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }


    public static String lowestString(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        Arrays.sort(strs , new MyComparator());

        String res = "";
        for(int i = 0 ; i < strs.length ; i ++){
            res += strs[i];
        }

        return res;
    }



}
