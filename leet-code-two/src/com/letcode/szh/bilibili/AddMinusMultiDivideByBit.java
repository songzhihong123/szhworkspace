package com.letcode.szh.bilibili;

/**
 * @ClassName AddMinusMultiDivideByBit
 * @Description AddMinusMultiDivideByBit
 * @Author szh
 * @Date 2024年01月09日
 */
public class AddMinusMultiDivideByBit {

    /*
    使用位运算进行加减乘除
     */


    // a ^ b  表示a和b无进位相加
    // a & b 把相同位置是1的位置拿出来，然后 (a & b) << 1 , 左移一位，则求出进位信息
    // 把以上两个数不断的进行求 无进位相加 和 进位信息，
    // 某一时刻，进位信息为0的时候，无进位相加的结果就是两者的和
    public static int add(int a , int b){

        int sum = a;

        while(b != 0){
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
        }


        // 减法就是 a 加上 b的相反数
        public static int minus(int a , int b){

            return add(a , negNum(b));
        }

        // 求一个数的相反数
        // 这个数取反和1相加的结果
        public static int negNum(int n){
            return add(~n ,  1);
        }


        //乘法
        public static int multi(int a , int b){
            int res = 0;
            while(b != 0){
                // b的最后一位不是0 ， 则相加
                if((b & 1 ) != 0){
                    res = add(res , a);
                }
                // a向左移动一位
                a <<= 1;
                // b向右无符号移动一位
                b >>>= 1;
            }
            return res;
        }

        public static boolean isNeg(int n){
            return n < 0;
        }


        public static int div(int a, int b){
            int x = isNeg(a) ? negNum(a) : a;
            int y = isNeg(b) ? negNum(b) : b;
            int res = 0;
            for(int i = 31 ; i > -1 ; i = minus(i , 1)){
                if((x >> i) >= y){
                    res |= (1 << i);
                    x = minus(x , y << i);
                }
            }
            return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
        }









    public static void main(String[] args) {
        System.out.println(negNum(5));
        System.out.println(Integer.toBinaryString(-5));
    }



}
