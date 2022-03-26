package com.song.simple.day4;


public class _344 {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while(left <= right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left ++;
            right --;
        }

    }



    public static void main(String[] args){
        _344 obj = new _344();
        char[] s= {'h','e','l','l','o'};
        obj.reverseString(s);

    }





}
