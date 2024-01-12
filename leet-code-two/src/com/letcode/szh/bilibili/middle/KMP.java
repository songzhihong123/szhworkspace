package com.letcode.szh.bilibili.middle;

/**
 * @ClassName KMP
 * @Description KMP
 * @Author szh
 * @Date 2024年01月12日
 */
public class KMP {



    public static int kmp(String str1 , String str2){

        if(str1 == null || str2 == null || str2.length() < 1 || str1.length() < str2.length()){
            return -1;
        }

        char[] strChar = str1.toCharArray();
        char[] strChar2 = str2.toCharArray();

        int i1 = 0;
        int i2 = 0;

        int[] next = getCharArrNext(strChar2);

        while(i1 < strChar.length && i2 < strChar2.length){
            if(strChar[i1] == strChar2[i2]){
                i1 ++;
                i2 ++;
            }else if(i2 == 0){
                i1 ++;
            }else{
                i2 = next[i2];
            }

        }

        return i2 == strChar2.length ? i1 - i2 : -1;
    }


    // 生成一个前缀数组
    // next[i] 表示 0 到 i - 1 位置 的最长的前缀的长度
    public static int[] getCharArrNext(char[] chars){
        if(chars.length == 0){
            return new int[]{-1};
        }

        int[] next = new int[chars.length];
        next[0] = -1;
        next[1] = 0;

        // ch 表示一个下标， 表示i-1 位置要比较的位置
        int ch = 0;

        int i = 3;

        while(i < chars.length){
            if(chars[i - 1] == chars[ch]){
                next[i] = next[i - 1] + 1;
                i ++;
                ch ++;
            }else if(ch > 0){
                ch = next[ch];
            }else{
                next[i] = 0;
                i ++;
            }
        }

        return next;
    }

    public static void main(String[] args) {
        System.out.println(kmp("cdabcabcdab" , "abcd"));
    }


}
