package com.letcode.szh.bilibili;

/**
 * @ClassName Manacher
 * @Description Manacher
 * @Author szh
 * @Date 2024年01月08日
 */
public class Manacher {


    /*
    字符串str中，最长回文字串的长度如何求解？
    如何做到时间复杂度O(N)完成
     */



    public static char[] manacherString(String str){
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for(int i = 0 ; i < res.length ; i ++){
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }


    public static int maxLcpsLength(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] str = manacherString(s); // 1221 -> #1#2#2#1#
        int[] pArr = new int[str.length]; //回文半径数组
        int C = -1; // 中心位置
        int R = -1; // 回文右边界的再往右一个位置， 最右的有效区是R-1位置
        int max = Integer.MIN_VALUE;

        // 每一个位置都求回文半径
        for(int i = 0 ; i < str.length ; i++){

            // pArr[i] 表示最小回文半径
            // 如果 i 大于 右边界 ， 回文半径就是当前数一个数， 赋值1
            // 如果 i 小于右边界 L表示当前上一个中心位置的最左回文位置  R表示当前上一个中心位置的最有回文位置
            //      a: i' 的回文半径在【L..R】 ，则赋值 1‘ 的回文半径  作为 i的回文半径
            //      b：' 的回文半径有一部分在L 还靠左， 则赋值 R - i 作为 i的回文半径
            //  2 * C - 1 是求 i' 的位置
            pArr[i] = i > R ? 1 : Math.min(R - i , pArr[2 * C - i]);

            // 不越界
            while(i + pArr[i] < str.length && i - pArr[i] > -1){
                if(str[i + pArr[i]] == str[i - pArr[i]]){
                    pArr[i] ++;
                }else{
                    break;
                }
            }
            if(i + pArr[i] > R){
                R = i + pArr[i];
                C = i;
            }

            max = Math.max(max , pArr[i]);
        }

        return max;
    }


}
