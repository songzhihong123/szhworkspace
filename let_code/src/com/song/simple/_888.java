package com.song.simple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zhihong Song on 2021/2/1 17:02
 */

public class _888 {

    public int[] fairCandySwap(int[] A, int[] B) {
        int[] result = new int[2];
        int aCount = Arrays.stream(A).sum();
        int bCount = Arrays.stream(B).sum();

        int countSize = aCount - bCount;
        int value = countSize / 2;
        int aLen = A.length;
        int bLen = B.length;
        if(countSize == 0){
            return result;
        }else if(countSize > 0){
            for (int i = 0; i < aLen; i++) {
                for (int j = 0; j < bLen; j++) {
                    if(A[i] - B[j] == value){
                        result[0] = A[i];
                        result[1] = B[j];
                        return result;
                    }
                }
            }
        }else { // countSize < 0
            for (int i = 0; i < bLen; i++) {
                for (int j = 0; j < aLen; j++) {
                    if(B[i] - A[j] == -value){
                        result[0] = A[j];
                        result[1] = B[i];
                        return result;
                    }
                }
            }
        }
        return result;
    }


    public int[] fairCandySwap1(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int delta = (sumA - sumB) / 2;
        Set<Integer> rec = new HashSet<Integer>();
        for (int num : A) {
            rec.add(num);
        }
        int[] result = new int[2];
        for(int y : B){
            int x = y + delta;
            if(rec.contains(x)){
                result[0] = x;
                result[1] = y;
            }
        }
        return result;
    }


    public static void main(String[] args){
        _888 obj = new _888();
        int[] A = {1,2,5};
        int[] B = {2,4};
        Arrays.stream(obj.fairCandySwap1(A, B)).forEach(System.out::print);
    }
}
