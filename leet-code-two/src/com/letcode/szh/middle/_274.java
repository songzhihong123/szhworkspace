package com.letcode.szh.middle;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ClassName _274
 * @Description _274
 * @Author szh
 * @Date 2023年11月29日
 */
public class _274 {

    public int hIndex(int[] citations) {

        // 0 , 1 , 3 , 5 , 6
        Arrays.sort(citations);

        int h = 0 ;
        int i = citations.length - 1;

        while(i >= 0 && citations[i] > h){
            h ++;
            i --;
        }

        return h;
    }


    public int hIndex1(int[] citations) {

        int n = citations.length;

        int[] counter = new int[n + 1];

        for(int i = 0 ; i < n ; i++){
            if(citations[i] >= n){
                counter[n] ++;
            }else{
                counter[citations[i]] ++;
            }
        }

        int tot = 0;

        for(int i = n ; i >= 0 ; i --){
            tot += counter[i];
            if(tot >= i){
                return i;
            }

        }

        return 0;
    }


    public static void main(String[] args) {

        _274 obj = new _274();

        int[] citations = {3,0,6,1,5};

        System.out.println(obj.hIndex1(citations));


    }


}
