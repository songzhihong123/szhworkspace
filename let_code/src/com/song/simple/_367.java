package com.song.simple;

public class _367 {

    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        while (left <= right){
            int middle = (right - left) / 2 + left;
            int temp = middle * middle;
            if(temp == num){
                return true;
            }else if(temp > num){
                right --;
            }else{
                left ++;
            }
        }
        return false;
    }


    public static void main(String[] args){
        _367 obj = new _367();
        int num = 1;
        System.out.println(obj.isPerfectSquare(num));


    }



}
