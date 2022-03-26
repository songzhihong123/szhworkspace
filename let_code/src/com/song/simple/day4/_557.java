package com.song.simple.day4;

public class _557 {

    public String reverseWords(String s) {
        StringBuilder build = new StringBuilder();
        String[] split = s.split(" ");
        int len = split.length;
        for(int i = 0 ; i < len ; i++){
            char[] chars = split[i].toCharArray();
            build.append(reverseString(chars));
            if(i != len - 1){
                build.append(" ");
            }
        }
        return build.toString();
    }


    public String reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while(left <= right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left ++;
            right --;
        }
        return String.valueOf(s);
    }



    public static void main(String[] aegs){
        _557 obj = new _557();
        String s = "Let's take LeetCode contest";
        System.out.println(obj.reverseWords(s));


    }



}
