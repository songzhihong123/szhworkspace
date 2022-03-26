package com.song.medium;


import java.util.HashMap;
import java.util.Map;

public class _1218 {

    public int longestSubsequence(int[] arr, int difference) {
        int result = 0;

        Map<Integer , Integer> dp = new HashMap<>();

        for(int ar : arr){
            dp.put(ar , dp.getOrDefault((ar - difference) , 0) + 1);
            result = Math.max(result , dp.get(ar));
        }

        return result;
    }


    public static void main(String[] args){
        _1218 obj = new _1218();
        int[] arr = {1,5,7,8,5,3,4,2,1};
        int difference = -2;
        System.out.println(obj.longestSubsequence(arr, difference));


    }


}
