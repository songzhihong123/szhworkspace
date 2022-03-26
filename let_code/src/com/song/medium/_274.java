package com.song.medium;

import java.util.Arrays;

public class _274 {


    public int hIndex(int[] citations) {
        // 0 1 3 5 6
        Arrays.sort(citations);
        int h = 0;
        int i = citations.length - 1;
        while(i >= 0 && citations[i] > h){
            h ++;
            i --;
        }
        return h;
    }

    public static void main(String[] args){
        _274 obj = new _274();
        int[] citations = {3,0,6,1,5};
        System.out.println(obj.hIndex(citations));
    }




}
