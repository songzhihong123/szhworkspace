package com.letcode.szh.bilibili.middle;

/**
 * @ClassName Rand5ToRand7
 * @Description Rand5ToRand7
 * @Author szh
 * @Date 2024年01月11日
 */
public class Rand5ToRand7 {


    /*
       1、
    已知一个函数，可以随机生成1 到 5 的随机数，
    求：
        定制一个函数，随机生成1 到 7

      思路： 将1到5的随机数的方法，加工成为一个随机生成0 和 1 的发生器
            然后随机生成0 到 6 上的随机数，加一即可



    给定一个函数f，以p概率返回0 ， 以 1 - p 的概率返回1 。请加工出等概率返回0 和 1 的函数g


    执行两次f函数
        第一次结果       第二次结果
           0                0        废弃(重新执行)
           1                1        废弃(重新执行)
           0                1       概率为 p(1-p)
           1                0       概率为 (1-p)p


      定制返回 01 结果是 0
      定制返回 10 结果是 1

     */



    public static int f(){
        return (int)(Math.random() * 5) + 1;
    }


    // 将1到5的随机数的方法，加工成为一个随机生成0 和 1 的发生器
    public static int r01(){
        int res = 0;

        do{
            res = f();
        }while (res == 3);

        return res < 3 ? 0 : 1;
    }

    // 等概率返回 1 到 7上面的数
    // 然后随机生成0 到 6 上的随机数，加一即可
    public static int g(){
        int res = 0;

        do{
            res = (r01()) << 2  + (r01()) << 1 + r01();
        }while (res == 7);

        return res + 1;
    }



}
