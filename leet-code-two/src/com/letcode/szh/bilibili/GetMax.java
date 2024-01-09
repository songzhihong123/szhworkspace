package com.letcode.szh.bilibili;

/**
 * @ClassName GetMax
 * @Description GetMax
 * @Author szh
 * @Date 2024年01月09日
 */
public class GetMax {


    /*
    返回两个数中的大数， 不用比较符号
     */




    // 保证参数不是1 就是 0
    // 1 -> 0
    // 0 -> 1
    public static int flip(int n){
        return n ^ 1;
    }

    // n 是非负数， 返回1
    // n 是负数，返回0
    public static int sign(int n){
        return flip( (n >> 31) & 1 );
    }

    // 问题：a - b 可能会溢出
    public static int getMax1(int a , int b){
        int c = a - b;
        int scA = sign(c); // a - b 非负数 =》 1  a - b 是负数 =》 0
        int scB = flip(scA); // scA 为0  scB就为1 ； scA 为1  scB就为0；

        // scA 为0 ， scB必为1 ； scA 为1 ， scB必为0
        return scA * a + scB * b;
    }


    // 可以解决溢出问题
    public static int getMax2(int a , int b){
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);

        int difSab = sa ^ sb; // a和b的符号一样，返回0 ； 符号不一样，返回1；
        int sameSab = flip(difSab); // a和b的符号一样，返回1 ； 符号不一样，返回0；

        // 返回a的条件是：
        //      1、如果a 和 b的符号不一样【difSab=0】，并且 a是正数【sa = 1】
        //      2、如果a 和 b的符号一样【sameSab=1】，并且 a > b 就是c是正数【sc = 1】
        int returnA = difSab * sa + sameSab * sc;
        // 返回b的条件
        int returnB = flip(returnA);


        return  returnA * a + returnB * b;
    }









}
