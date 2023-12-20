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


    // 超出时间限制
    public int guessNumber1(int n) {
        int left = 1;
        int right = n;

        while(left <= right){
            int middle = left + (right - left) / 2;
            int num = guess(middle);
            if(num == 0){
                return middle;
            }else if(num == -1){
                right = middle;
            }else if(num == 1){
                left = middle;
            }
        }

        return n;
    }


    public int guess(int num){

        return Integer.compare(6, num);
    }



    public static void main(String[] args) {
        _374 obj = new _374();

        int num = obj.guessNumber(10);

        System.out.println(num);
    }

}
