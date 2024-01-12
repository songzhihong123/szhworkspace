package com.letcode.szh.bilibili;

/**
 * @ClassName KMP
 * @Description KMP
 * @Author szh
 * @Date 2024年01月07日
 */
public class KMP {



    /*
    字符串str1 和 str2 ， str1是否包含str2 ， 如果包含返回str2在str1中开始的位置，
    如何做到时间复杂度O(N)
     */

    public static int kmp(String s , String m){
        if(s == null || m == null || m.length() < 1 || s.length() < m.length()){
            return -1;
        }

        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0 ;
        int i2 = 0;
        int[] next = getNextArray(str2);

        // i1越界 或者 i2越界 跳出循环
        // i2越界，匹配到了
        // i1 越界，没有匹配到
        while(i1 < s.length() && i2 < m.length()){
            if(str1[i1] == str2[i2]){
                i1 ++;
                i2 ++;
            }else if(next[i2] == -1){ // str2 中比对的位置已经无法往前跳了
                i1 ++;
            }else{
                i2 = next[i2];
            }
        }

        // i1越界 或者 i2越界
        return i2 == str2.length ? i1 - i2 : -1;
    }


    // 获取字符数组ms的每一个位置对应的字符的最大前缀个数
    // 前缀和后缀长度相等的最大长度， 不取到整体
    //
    public static int[] getNextArray(char[] ms){
        if(ms.length == 1){
            return new int[]{-1};
        }
        // next[i] 表示 [0..i-1] 位置的前缀的个数，
        int[] next = new int[ms.length];
        // 人为规定 第 0 个位置为 -1 ， 第一个位置为 0
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        // cn
        // 表示哪个位置的字符和 n - 1 的位置比较
        int cn = 0;

        while (i < next.length){
            if(ms[i - 1] == ms[cn]){
                next[i] = cn + 1;
                i ++;
                cn ++;
            }else if(cn > 0){ // 当前跳到cn位置的字符， 和i-1的位置的字符匹配不上
                cn = next[cn];
            }else{
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(kmp("cdabcabcdab" , "abcd"));
    }




}
