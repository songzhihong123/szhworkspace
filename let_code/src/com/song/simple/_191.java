package com.song.simple;

/**
 * Created by Zhihong Song on 2021/1/14 11:29
 */

public class _191 {


    /**
     * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
     */

    /**
     * 我们使用 位掩码 来检查数字的第 i 位。一开始，掩码 m=1 因为 1 的二进制表示是
     *
     * 0000 0000 0000 0000 0000 0000 0000 0001
     *
     * 显然，任何数字跟掩码 1 进行逻辑与运算，都可以让我们获得这个数字的最低位。检查下一位时，我们将掩码左移一位。
     *
     * 0000 0000 0000 0000 0000 0000 0000 0010
     *
     * 并重复此过程。
     *
     */
    public int hammingWeight(int n) {
        int res = 0;
        int temp = 1;
        for (int i = 0; i < 32; i++) {
            if((n & temp) != 0){
                res ++;
            }
            temp = temp << 1;
        }
        return res;
    }

    /**
     * 在二进制表示中，数字 n 中最低位的 1 总是对应 n−1 中的 0 。
     * 因此，将 n 和 n−1 与运算总是能把 n 中最低位的 1 变成 0 。
     */
    public int hammingWeight2(int n) {
       int res = 0;
       while(n != 0) {
           res ++;
           n = n & (n - 1);
       }
        return res;
    }



    public static void main(String[] args) {
        int n = 5;
        System.out.println(Integer.bitCount(n));
    }

}
