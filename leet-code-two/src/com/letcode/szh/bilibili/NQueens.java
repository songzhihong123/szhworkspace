package com.letcode.szh.bilibili;

/**
 * @ClassName NQueens
 * @Description N皇后问题
 * @Author szh
 * @Date 2024年01月06日
 */
public class NQueens {

    /*




     */

    public static int num1(int n){
        if(n < 1){
            return 0;
        }
        //record[i] 表示 i行的皇后放在第几列
        int[] record = new int[n];

        return process1(0 , record , n);
    }

    // i 表示当前来到了第几行
    //record[0..i-1] 表示之前的行，放了皇后的位置
    //n代表一共有多少行
    // 返回值是摆满了皇后，合理的摆法有多少种
    public static int process1(int i , int[] record , int n){
        if(i == n){ // 如果 i来到了 最后， 表示有一种合理的摆法
            return 1;
        }
        int res = 0;
        // 遍历第i行的所有列，依次放皇后，看是否符合规则
        for(int j = 0 ; j < n ;j++){
            // 当时i行的皇后，放在j列，会不会和之前的（0..i-1）的皇后，共行共列或者共斜线
            // 如果是，则无效
            // 如果不是，认为有效
            if(isValid(record , i , j)){
                record[i] = j;
                res += process1( i + 1 , record , n);
            }
        }
        return res;
    }

    // 判断第i行的j列是否可以放皇后
    public static boolean isValid(int[] record , int i , int j){
        // 1、只需要判断从0行开始到i行的数值
        for(int k = 0 ; k < i ; k++){
            // 不共列 && 不共斜线(行坐标差值的绝对值 != 列坐标差值的绝对值)
            // (2,4) 和 （5 ，1） 共斜线 解释：|2 - 5| = |4 - 1|
            if(j == record[k] || (Math.abs(i - k) == Math.abs(j - record[k]))){
                return false;
            }
        }
        return true;
    }

}
