package com.letcode.szh.bilibili;

/**
 * @ClassName Hanoi
 * @Description Hanoi , 汉诺塔问题
 * @Author szh
 * @Date 2024年01月06日
 */
public class Hanoi {

    public static void hanni(int n){

        func(n , "左" , "右" , "中");
    }


    // 1 ~ i 圆盘 从 start 挪到 end 上面， other备用
    public static void func(int i , String start , String end , String other){
        if(i == 1){
            System.out.println("Move 1 from " + start + " to " + end);
            return;
        }

        func(i - 1 , start , other , end);
        System.out.println("Move "+ i +" from " + start + " to " + end);
        func(i -1 , other , end , start);


    }


    public static void main(String[] args) {
        int n = 3;
        hanni(n);
    }





}
