package com.song.simple;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-15 09:28
 **/
public class _374 {


    //二分法：超出时间限制
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while(left < right){
            int mid =  left +  (right - left) / 2;
            int pick = guess(mid);
            if(pick <= 0){
               right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }



    public static void main(String[] args){
        _374 obj = new _374();
        int n = 10;
        System.out.println(obj.guessNumber(n));
    }


    /**
     * @Description:
     *  -1 if num is lower than the guess number
     *  1 if num is higher than the guess number
     *  otherwise return 0
     *
     * @Author: szh
     **/
    int guess(int num){

        return -1;
    }

}
