package com.song.difficlult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhihong Song on 2021/2/9 10:45
 */

public class _992 {

    public int subarraysWithKDistinct(int[] A, int K) {

        return atMostKDistinct(A,K) - atMostKDistinct(A , K - 1);
    }

    private int atMostKDistinct(int[] A , int K){
        int len = A.length;
        int[] freq = new int[len + 1];
        int left = 0 ;
        int right = 0;

        int count = 0;
        int res = 0;
        while(right < len){
            if(freq[A[right]] == 0){
                count ++;
            }
            freq[A[right]] ++;
            right ++;
            while (count > K){
                freq[A[left]] --;
                if (freq[A[left]] == 0){
                    count --;
                }
                left ++;
            }
            res += right - left;
        }
        return res;
    }



    public static void main(String[] args){
        _992 obj = new _992();
        int[] A = {1,2,1,2,3};
        int K = 2;
        System.out.println(obj.subarraysWithKDistinct(A, K));

    }


}
