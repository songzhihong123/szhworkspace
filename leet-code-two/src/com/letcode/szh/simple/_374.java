package com.letcode.szh.simple;

/**
 * @ClassName _374
 * @Description _374
 * @Author szh
 * @Date 2023年12月19日
 */
public class _374 {


    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while(left < right){
            int middle = left + (right - left) / 2;
            if(guess(middle) <= 0){
                right = middle;
            }else{
                left = middle + 1;
            }
        }
        return left;
    }


    public int guess(int num){

        return 0;
    }



    public static void main(String[] args) {

    }

}
