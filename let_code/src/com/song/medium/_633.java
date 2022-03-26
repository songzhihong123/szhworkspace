package com.song.medium;/**
 * Created by Zhihong Song on 2021/4/28 17:47
 */

/**
 * @program: let_code
 * @description:
 * @author: szh
 * @create: 2021-04-28 17:47
 **/
public class _633 {


    public boolean judgeSquareSum(int c) {
        if(Math.sqrt(c) == 0){
            return true;
        }
        int max = (int)Math.floor(Math.sqrt(c));
        for (int i = max; i >= 0; i--) {
            int sec = c - i * i ;
            if(Math.sqrt(sec) == (int)(Math.sqrt(sec))){
                return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSum1(int c) {
        long left = 0 ;
        long right = (long)Math.sqrt(c);
        while(left <= right){
            long sum = left * left + right * right;
            if(sum == c){
                return true;
            }else if(sum > c){
                right --;
            }else {
                left ++;
            }
        }
        return false;
    }


    public static void main(String[] args){
        _633 obj = new _633();
        int c = 2;
        System.out.println(obj.judgeSquareSum1(c));
    }

}
