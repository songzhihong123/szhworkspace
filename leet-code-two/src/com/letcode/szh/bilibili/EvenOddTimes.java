package com.letcode.szh.bilibili;

/**
 * @ClassName EvenOddTimes
 * @Description
 * @Author szh
 * @Date 2024年01月02日
 *
 *
 * 1、找一个数组中出现一个奇数次的数字
 * 2、找一个数组中出现二个奇数次的数字
 *
 *
 */
public class EvenOddTimes {


    // 找一个数组中出现一个奇数的数字
    public static void printOddTimeNum(int[] arr){
        int eor = 0;

        for(int cur : arr){
            eor ^= cur;
        }

        System.out.println(eor);
    }

    // 找一个数组中出现二个奇数的数字 a , b
    public static void printOddTimeNum2(int[] arr){
        int eor = 0;
        for(int cur : arr){
            eor ^= cur;
        }
        // eor = a ^ b
        // eor != 0
        // eor 必然有一个位置上是1 ， 表示 a 和 b 的 这个位置上一定是不相等的
        int rightOne = eor & (~eor + 1); // 提取出最右位置的1

        int onlyOne = 0;
        for(int cur : arr){
            if((cur & rightOne) == 1){
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));

    }







}
