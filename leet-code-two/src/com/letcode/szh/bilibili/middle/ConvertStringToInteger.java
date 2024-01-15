package com.letcode.szh.bilibili.middle;

/**
 * @ClassName ConvertStringToInteger
 * @Description ConvertStringToInteger
 * @Author szh
 * @Date 2024年01月14日
 */
public class ConvertStringToInteger {

    /*

    给定一个字符串， 如果该字符串符合人们日常书写一整数的形式，返回int类型的这个数
    如果不沽河或者越界返回-1或者报错


     */


    public static int convert(String s){
        if(s == null || s.equals("")){
            return 0;
        }
        char[] str = s.toCharArray();
        if(!isValid(str)){
            throw new RuntimeException("cna not convert");
        }
        boolean neg = str[0] == '-';
        int minq = Integer.MIN_VALUE / 10;
        int minr = Integer.MIN_VALUE % 10;

        // 结算中的结果需要用负数接收
        int res = 0;
        int cur = 0;

        for(int i = neg ? 1 : 0 ; i < str.length; i++){

            // str[i] == '0' cur -> 0
            // str[i] == '1' cur -> -1
            // str[i] == '4' cur -> -4
            // 注意：这里需要使用负数接收
            // 因为 负数(-2147483648)的绝对值，比正数(2147483647)的绝对大 1
            cur = '0' - str[i];

            // 判断越界行为
            if((res < minq) || (res == minq && cur < minr)){
                throw new RuntimeException("can not convert");
            }

            res = res * 10 + cur;
        }

        if(!neg && res == Integer.MAX_VALUE){
            throw new RuntimeException("can not convert");
        }


        return neg ? res : -res;

    }












    // 检查某一个字符串str，是否符合日常书写标准
    public static boolean isValid(char[] str){
        if(str[0] != '-' && (str[0] < '0' || str[0] > '9')){
            return false;
        }


        if(str[0] == '-' && (str.length == 1 || str[1] == '0')){
            return false;
        }

        if(str[0] == '0' && str.length > 1){
            return false;
        }

        for(int i = 1 ; i < str.length ; i++){
            if(str[i] < '0' || str[i] > '9'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }







}
