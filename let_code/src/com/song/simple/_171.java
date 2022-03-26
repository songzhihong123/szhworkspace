package com.song.simple;

public class _171 {



    public int titleToNumber(String columnTitle) {
        int number = 0;
        int len = columnTitle.length();
        int multiple = 1;
        for (int i = len - 1; i >= 0; i--) {
            int k = columnTitle.charAt(i) - 'A' + 1;
            number += k * multiple;
            multiple *= 26;
        }
        return number;
    }



    public static void main(String[] args){
        _171 obj = new _171();
        String columnTitle = "FXSHRXW";
        System.out.println(obj.titleToNumber(columnTitle));
    }


}
