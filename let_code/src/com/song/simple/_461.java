package com.song.simple;

/**
 * @description:
 * @author: szh
 * @create: 2021-05-27 15:26
 **/
public class _461 {

    //两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。

    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        String binaeyStr = Integer.toBinaryString(z);
        int result = 0;
        char[] chars = binaeyStr.toCharArray();
        for(char chr : chars){
            if(chr == '1'){
                result ++;
            }
        }
        return result;
    }

    public int hammingDistance1(int x, int y) {
        int z = x ^ y;
        return Integer.bitCount(z);
    }

    public int hammingDistance2(int x, int y) {
        int z = x ^ y;
        int ret = 0;
        while (z != 0){
            ret += z & 1 ;
            z >>= 1;
        }
        return ret;
    }

    public int hammingDistance3(int x, int y) {
        int z = x ^ y;
        int ret = 0;
        while (z != 0){
            z &= z - 1;
            ret++;
        }
        return ret;
    }


    public static void main(String[] args){
        _461 obj = new _461();
        int x = 1;
        int y = 4;
        System.out.println(obj.hammingDistance2(x, y));
    }


}
