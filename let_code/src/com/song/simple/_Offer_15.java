package com.song.simple;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-24 16:08
 **/
public class _Offer_15 {



    public int hammingWeight(int n) {
        int result = 0;
        while(n != 0){
            n = n & (n- 1);
            result ++;
        }
        return result;
    }

    // 超时
    public int hammingWeight2(int n) {
        int result = 0;
        while(n != 0){
            if((n & 1) != 0){
                result ++;
            }
            n = n >> 1;
        }
        return result;
    }


    public int hammingWeight1(int n) {
        return Integer.bitCount(n);
    }



    public static void main(String[] args){
        _Offer_15 obj = new _Offer_15();
        int n = 5;
        System.out.println(obj.hammingWeight(5));
    }



}
