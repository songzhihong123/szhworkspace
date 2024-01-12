package com.letcode.szh.bilibili.middle;

/**
 * @ClassName ParenthesesDeep
 * @Description ParenthesesDeep
 * @Author szh
 * @Date 2024年01月11日
 */
public class ParenthesesDeep {


    /*

        1、求一个合法的括号字符串的最大深度
           例子："()(((())))"  => 4


         2、求一个合法括号字符串的 合法子字符串最大长度
            例子："())(())(()(()))" => "(())(()(()))" 12


     */



    // 求一个合法的括号字符串的最大深度 , 求左括号出现最大值即可
    public static int deep(String s){
        char[] str = s.toCharArray();

        int count = 0;
        int res = 0;

        for(int i = 0 ; i < str.length ; i++){
            if(str[i] == '('){
                count ++;
                res = Math.max(res , count);
            }else{
                count --;
            }
        }
        return res;
    }


    // 求一个合法括号字符串的 合法的子字符串最大长度 , 第一个
    public static int maxLength(String s){
        if(s == null || s.equals("")){
            return 0;
        }
        char[] str = s.toCharArray();

        // dp[i] 表示以下标i的最大子字符串
        int[] dp = new int[str.length];

        int pre = 0;
        int res = 0;

        for(int i = 1  ; i < str.length ; i ++){
            if(str[i] == ')'){
                pre = i - dp[i - 1] -1; // 与str[i]配对的左括号的位置pre
                if(pre >= 0 && str[pre] == '('){
                    dp[i] = dp[i - 1] + 2 + ((pre - 1) >= 0 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res , dp[i]);
        }
        return res;
    }





}
