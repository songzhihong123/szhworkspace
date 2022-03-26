package com.song.simple;

/**
 * @description:
 * @author: szh
 * @create: 2021-05-31 14:15
 **/
public class _231 {

    

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n- 1)) == 0;
    }

    public static void main(String[] args){
        _231 obj = new _231();
        int n = 4;
        System.out.println(obj.isPowerOfTwo(n));
    }

}
