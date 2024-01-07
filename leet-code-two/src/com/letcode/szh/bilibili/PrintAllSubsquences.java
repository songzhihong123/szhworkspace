package com.letcode.szh.bilibili;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PrintAllSubsquences
 * @Description 打印子序列
 * @Author szh
 * @Date 2024年01月06日
 */
public class PrintAllSubsquences {


    public static void printAllSubsquences1(String str){
        char[] chs = str.toCharArray();

        process1(chs , 0);
    }

    // 当前来到i位置，要和不要，走两条路
    public static void process1(char[] chs , int i){
        if(i == chs.length){
            System.out.println(String.valueOf(chs));
            return;
        }

        // 要当前字符
        process1(chs , i + 1);
        char tem = chs[i];
        chs[i] = 0 ;

        // 不要当前字符
        process1(chs , i + 1);
        chs[i] = tem;

    }

    public static void printAllSubsquences2(String str){
        char[] chs = str.toCharArray();

        process2(chs , 0 , new ArrayList<>());
    }

    // 当前来到i位置，要和不要，走两条路
    // i表示来到了当前位置 ，
    public static void process2(char[] str , int i , List<Character> res){
        if(i == str.length){
            printList(res);
            return;
        }

        List<Character> resKeep = copyList(res);
        resKeep.add(str[i]);
        process2(str , i+ 1 , resKeep); // 要当前的字符

        List<Character> resNoInclude = copyList(res);
        process2(str , i+ 1 , resNoInclude); // 不要当前的字符

    }

    public static void printList(List<Character> res){
        //...
    }

    public static List<Character> copyList(List<Character> res){
        //...
        return null;
    }




    public static void main(String[] args) {
        printAllSubsquences1("abc");
    }




}
