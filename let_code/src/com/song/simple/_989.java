package com.song.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Zhihong Song on 2021/1/22 8:47
 */

public class _989 {

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> resList = new ArrayList<>();
        int len = A.length;
        for (int i = len - 1 ; i >= 0; i--){
            int sum = A[i] + K % 10;
            K /= 10;
            if(sum >= 10){
                K ++;
                sum -= 10;
            }
            resList.add(sum);
        }
        for (;K > 0 ; K /= 10){
            resList.add(K % 10);
        }
        Collections.reverse(resList);
        return resList;
    }


    public static void main(String[] args){
        _989 obj = new _989();
//        int[] A = {1,2,0,0};
//        int  K = 34;
        int[] A = {2,7,4};
        int  K = 181;

//        int[] A = {9,9,9,9,9,9,9,9,9,9};
//        int  K = 1;
        obj.addToArrayForm(A,K).stream().forEach(System.out::print);
    }

}
