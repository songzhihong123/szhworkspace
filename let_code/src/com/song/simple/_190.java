package com.song.simple;

/**
 * Created by Zhihong Song on 2021/3/29 21:15
 */

public class _190 {




    public int reverseBits1(int n) {
        int res = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            res |= (n & 1) << (31 - i);
            n = n >>> 1;
        }
        return res;
    }

    public int reverseBits(int n) {
        return Integer.reverse(n);
    }

    public static void main(String[] args){
        int n = 43261596;
        _190 obj = new _190();
        System.out.println(obj.reverseBits(n));
        System.out.println(obj.reverseBits1(n));


    }



}
