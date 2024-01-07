package com.letcode.szh.bilibili;

import java.util.ArrayList;

/**
 * @ClassName PrintAllPermutations
 * @Description PrintAllPermutations
 * @Author szh
 * @Date 2024年01月06日
 */
public class PrintAllPermutations {

    /*
    打印一个字符串的所有排列
     */

    public static ArrayList<String> permutation(String str){
        ArrayList<String> res = new ArrayList<>();
        char[] strChar = str.toCharArray();
        // 重复
        process(strChar , 0 , res);
        // 不重复
//        process1(strChar , 0 , res);
        return res;
    }

    // str[i..]范围上， 所有的字符， 都可以在i位置上，后续都去尝试
    //str[0..i-1] 范围上，是之前形成的全排列， 加入到res中
    public static void process(char[] str , int i , ArrayList<String> res){
        if(i == str.length){
            res.add(String.valueOf(str));
        }

        // i 位置后面的字母
        for(int j = i ; j < str.length ; j++ ){
            swap(str , i , j);
            process(str , i + 1 , res);
            swap(str , i , j);
        }
    }



    // 去重
    public static void process1(char[] str , int i , ArrayList<String> res){
        if(i == str.length){
            res.add(String.valueOf(str));
        }

        // i 位置后面的字母 都可以来到i位置上
        boolean[] visit = new boolean[26];
        for(int j = i ; j < str.length ; j++ ){
            if(!visit[str[j] - 'a']){
                visit[str[j] - 'a'] = true;
                swap(str , i , j);
                process1(str , i + 1 , res);
                swap(str , i , j);
            }
        }
    }

    public static void swap(char[] str , int i , int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }


    public static void main(String[] args) {
        permutation("abc").forEach(System.out::println);
    }


}
