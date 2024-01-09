package com.letcode.szh.bilibili;

/**
 * @ClassName Power
 * @Description Power
 * @Author szh
 * @Date 2024年01月09日
 */
public class Power {

    // 判断是不是2的幂
    public static boolean is2Power (int n){
        return (n & (n - 1)) == 0;
    }

    // 判断是不是4的幂
    public static boolean is4Power(int n){
               // 是不是2的幂               //01..1010101
        return (n & (n - 1)) == 0 && (n & 0x55555555) != 0;

    }



}
