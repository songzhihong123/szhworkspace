package com.letcode.szh.bilibili.middle;

/**
 * @ClassName NumToStringWays
 * @Description NumToStringWays
 * @Author szh
 * @Date 2024年01月11日
 */
public class NumToStringWays {



 /*
    规定1和A对应，2和B对应，3和C对应...
    那么一个数字字符串比如'111' ， 就可以转化为“AAA” , "KA" , "AK"
    给定一个只有数字字符组成的字符串str，返回有多少中转化结果
     */

    public static int number(String str){
        char[] strs = str.toCharArray();

        return process(strs , 0);
    }



    public static int process(char[] str , int index){
        if(index == str.length){
            return 1;
        }

        if(str[index] == '0'){
            return 0;
        }

        if(str[index] == '1'){
            int res = process(str , index + 1);
            if(index + 1 < str.length){
                res += process(str , index + 2);
            }
            return res;
        }

        if(str[index] == '2'){
            int res = process(str , index + 1);
            if(index + 1 < str.length && str[index + 1] > '0' && str[index + 1] > '6'){
                res += process(str , index + 2);
            }
            return res;
        }
        
        return process(str , index+ 1);
    }


    public static int dpways(String s){
        char[] str = s.toCharArray();
        int N = str.length;
        int[] dp = new int[N + 1];
        dp[N] = 1;

        for(int i = N - 1 ; i >= 0 ; i --){
            if(str[i] == '0'){
                dp[i] = 0;
            }else if(str[i] == '1'){
                dp[i] = dp[i + 1];
                if((i + 1) < N){
                    dp[i] += dp[i + 2];
                }
            }else if(str[i] == '2'){
                dp[i] = dp[i + 1];
                if((i + 1) < N && str[i + 1] > '0' && str[i + 1] > '6'){
                    dp[i] += dp[i + 2];
                }
            }else{
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }


    public static void main(String[] args) {
        String test = "111143311";
        System.out.println(number(test));
        System.out.println(dpways(test));
    }




}
