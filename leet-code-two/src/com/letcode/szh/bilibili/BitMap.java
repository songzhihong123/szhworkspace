package com.letcode.szh.bilibili;

/**
 * @ClassName BitMap
 * @Description BitMap 位图
 * @Author szh
 * @Date 2024年01月07日
 */
public class BitMap {


    public static void main(String[] args) {


        int[] arr = new int[10]; // 32bit * 10 -> 320 0bit

        int i = 178; // 想取得第178个bit的状态

        // 找到应该在哪个位置上
        int numIndex = i / 32;
        //找到在某个位置的 哪个 bit 上
        int bitIndex = i % 32;

        // 拿到178位的状态
        // 右移之后把想要的那个位置移位到最后的位置上
        // arr[numIndex] >> bitIndex 操作之后，就是想要的位跑到了最右侧
        int s = ( (arr[numIndex] >> bitIndex)    & 1);


        // 请把178位的状态改成1
        // 1 向右移位 bitIndex
        arr[numIndex] = arr[numIndex] | (1 << bitIndex);


        // 请把178位的状态改成0
        arr[numIndex] = arr[numIndex] & (~ (1 << bitIndex));


    }




}
