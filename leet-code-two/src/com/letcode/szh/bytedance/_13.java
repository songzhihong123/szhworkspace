package com.letcode.szh.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName _13
 * @Description 罗马数字转整树
 * @Author szh
 * @Date 2024年01月02日
 */
public class _13 {


    public int romanToInt(String s) {

        int len = s.length();

        if(len == 1){
            return getValue(s.charAt(0));
        }

        int res = 0;

        // LVIII
        // IV
        for(int i = 1 ;i < len ; i ++){
            char y = s.charAt(i);
            char x = s.charAt(i - 1);
            if(getValue(y) <= getValue(x)){
               res +=  getValue(x);
            }else {
                res -= getValue(x);
            }
        }
        res += getValue(s.charAt(s.length() - 1));
        return res;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }




    public static void main(String[] args) {
        _13 obj = new _13();
        String s = "III";

        System.out.println(obj.romanToInt(s));


    }





}
