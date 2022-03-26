package com.song.medium;

public class _38 {


    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder builder = new StringBuilder();
            int start = 0;
            int pos = 0;
            while(pos < str.length()){
                while(pos < str.length() && str.charAt(pos) == str.charAt(start)){
                    pos ++;
                }
                builder.append(pos - start).append(str.charAt(start));
                start = pos;
            }
            str = builder.toString();
        }
        return str;
    }


    public String countAndSay1(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder builder = new StringBuilder();
            int start = 0 ;
            int pos = 0;
            while(pos < str.length()){
                while(pos < str.length() && str.charAt(start) == str.charAt(pos)){
                    pos ++;
                }
                builder.append(pos - start).append(str.charAt(start));
                start = pos;
            }
            str = builder.toString();
        }
        return str;
    }



    public static void main(String[] args){
        _38 obj = new _38();
        int n = 5;
        System.out.println(obj.countAndSay(n));
    }



}
