package com.song.medium;/**
 * Created by Zhihong Song on 2021/4/21 8:44
 */

/**
 * @program: let_code
 * @description:
 * @author: szh
 * @create: 2021-04-21 08:44
 **/
public class _91 {

    //TODO 动态规划实现

    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            if (s.charAt(i - 1) != '0'){
                dp[i] += dp[i - 1];
            }
            if(i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)){
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }

    public static void main(String[] args){
        _91 obj = new _91();
        String s = "226";
        System.out.println(obj.numDecodings(s));
    }


}
