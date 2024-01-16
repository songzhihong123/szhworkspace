package com.letcode.szh.bilibili.middle;

/**
 * @ClassName ChineseExpression
 * @Description ChineseExpression
 * @Author szh
 * @Date 2024年01月15日
 */
public class ChineseExpression {

    // 1 到 9 范围
    public static String num1To9(int num){
        if(num < 1 || num > 9){
            return "";
        }
        String[] names = {"一" ,"二" , "三" , "四" , "五" , "六" , "七" , "八" ,"九" ,"十"};

        return names[num - 1];
    }

    // 1 到 99
    public static String num1To99(int num , boolean hasBai){
        if(num < 1 || num > 99){
            return "";
        }
        if(num < 10){
            return num1To9(num);
        }
        int shi = num / 10;

        if(shi == 1 && (!hasBai)){ // 十七
            return "十" + num1To9(num % 10);
        }else{ //一十七
            return num1To9(shi) + "十" + num1To9(num % 10);
        }

    }

    // 1 到 999
    public static String num1To999(int num){
        if(num < 1 || num > 999){
            return "";
        }
        if(num < 99){
            return num1To99(num, false);
        }
        String res = num1To9(num / 100) + "百";

        int rest = num % 100;

        if(rest == 0){ // 十七
            return res;
        }else if (rest >= 10){ //一十七
            res += num1To99(rest , true);
        }else{
            res += "零" + num1To9(rest);
        }
        return res;
    }


    // 1 到 9999
    public static String num1To9999(int num){
        if(num < 1 || num > 9999){
            return "";
        }
        if(num < 999){
            return num1To999(num);
        }
        String res = num1To9(num / 1000) + "千";

        int rest = num % 1000;

        if(rest == 0){ // 十七
            return res;
        }else if (rest >= 100){ //一十七
            res += num1To999(rest);
        }else{
            res += "零" + num1To99(rest ,true);
        }
        return res;
    }

    // 1 到 9999
    public static String num1To99999999(int num){
        if(num < 1 || num > 99999999){
            return "";
        }
        int wan = num / 10000;
        int rest = num % 10000;

        if(wan == 0){
            return num1To9999(rest);
        }

        String res = num1To9999(wan) + "万";

        if(rest == 0){
            return res;
        }else if (rest < 1000){ //一十七
            return res + "零" + num1To999(rest);
        }else{
            return res + num1To9999(rest);
        }
    }

    public static String getNumChiExp(int num){
        if(num == 0){
            return "零";
        }

        String res = num < 0 ? "负" : "";

        int yi = Math.abs(num / 100000000);
        int rest = Math.abs(num % 100000000);

        if(yi == 0){
            return num1To99999999(rest);
        }

        res += num1To9999(yi) + "亿";

        if(rest == 0){
            return res;
        }else{
            if(rest < 10000000){
                return  res + "零" + num1To99999999(rest);
            }else{
                return  res + num1To99999999(rest);
            }
        }

    }


    public static void main(String[] args) {
        System.out.println(0);
        System.out.println(getNumChiExp(0));

        System.out.println(Integer.MIN_VALUE);
        System.out.println(getNumChiExp(Integer.MIN_VALUE));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(getNumChiExp(Integer.MAX_VALUE));

        System.out.println(getNumChiExp(10));

        System.out.println(getNumChiExp(1010));

        System.out.println(getNumChiExp(100010));

    }




}
