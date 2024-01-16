package com.letcode.szh.bilibili.middle;

/**
 * @ClassName Mode3Num
 * @Description Mode3Num
 * @Author szh
 * @Date 2024年01月15日
 */
public class Mode3Num {

    /*

    小Q得到一个神奇的数列：1 ， 12 ， 123 ，1234 .. 12345678910 1234567891011...，
    并且小Q对于能否被3整除这个性质很感兴趣。
    小Q现在希望你能帮他计算一下从数列的第L到第R(包含端点)有多少个数可以被3整除。

    输入描述：
     输入包括两个整数L和R ， 表示要求解的区间两端

     输出描述：
     输出一个整数， 表示区间内能被3整除的数字个数



      判断一个数是否可以被3整除 ， 只需要判断各个位置上的数之和是否可以被3整除

      比如：999 可以被3整除， 那么， 9 + 9 + 9 = 27 可以被3整除


     */


    public static int mode3Num(int L , int R){
        int res = 0;

        for(int i = L ; i<=R ; i++){
            // n(a1 + an) / 2  是等差数列的前n项和
            if(((i * (1 + i)) / 2) % 3 == 0){
                res ++;
            }

        }
        return res;
    }


    public static void main(String[] args) {

        System.out.println(mode3Num(2 , 5));

    }


}
