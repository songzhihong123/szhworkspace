package com.song.medium;

import java.util.Arrays;

/**
 * Created by Zhihong Song on 2021/1/14 9:40
 */

public class _338 {

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = findResult(i);
        }
        return res;
    }

    /**
     * i 的二进制字符串里面有几个1
     * @param i
     * @return
     */
    private int findResult(int i){
        int bit = 0;
        while(i != 0){
            bit ++;
            i = i & (i-1);
        }
        return bit;
    }

    public static void main(String[] args) {
        _338 obj = new _338();
        Arrays.stream(obj.countBits(5)).forEach(System.out::print);
    }

}
