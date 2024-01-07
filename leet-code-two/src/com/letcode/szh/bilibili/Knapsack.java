package com.letcode.szh.bilibili;

/**
 * @ClassName Knapsack
 * @Description Knapsack
 * @Author szh
 * @Date 2024年01月06日
 */
public class Knapsack {

    /*
    给定两个长度都为N的数据weights和values，weight[i]和values[i]分别代表
    i号物品的重量和价值。给定一个正数bag，表示一个载重bag的袋子，你装的物品不能超过
    这个重量，返回您呢个装下最多的价值是多少
     */



    // weights 表示重量 ， values表示价值 ，bag表示背包大小
    // i 表示来到第几个 。 alreadyweight 表示已经获得的货物重量
    //i.. 的货物自由选择， 形成最大价值返回
    public static int process1(int[] weights , int[] values , int i , int alreadyweight , int bag){
        // 已经获得货物的重量大于最大重量，然会价值为o
        if(alreadyweight > bag){
            return 0;
        }
        // 当前位置到了最后，价值为0
        if(i == weights.length){
            return 0;
        }

        // 不要i号的货物的价值
        int value1 = process1(weights , values , i + 1 , alreadyweight , bag);

        // 要i号货物的价值
        int value2 = values[i] + process1(weights , values , i + 1 , alreadyweight + weights[i] , bag);

        return Math.max(value1 , value2);
    }




}
