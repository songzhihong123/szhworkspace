package com.letcode.szh.bilibili.middle;

/**
 * @ClassName PackingMachine
 * @Description PackingMachine
 * @Author szh
 * @Date 2024年01月11日
 */
public class PackingMachine {


    /*

        有n个打包机其从左到右一字排开 ， 上方有一个自动装置会抓去一批放物品到每个打包机上，
        放到每个机器上的物品进行移动从而到达物品的数量相等才能打包。每个物品重量太大、每次
        只能般一个物品进行移动，为了省力，只在相邻的机器上移动。

        请计算在搬动最小轮数的前提下， 是每个机器上的物品数量相等。如果不能使每个机器上的物品
        相同，则返回-1



        划分三个位置

        左侧  i  右侧

        1、左侧右侧都是负数，说明i位置需要往出去扔衣服 ， 数量是两侧的绝对值之和
        2、左侧右侧都是正数， 说明i位置需要接收衣服 ， 数量是两侧绝对值的最大值 【因为i位置扔衣服只能一件一件扔， i位置接收衣服可以是同时接收】
        3、左侧负数右侧正数，说明i位置需要接收衣服和扔衣服， 数量是 数量是两侧绝对值的最大值
        4、左侧正数右侧负数，说明i位置需要接收衣服和扔衣服， 数量是 数量是两侧绝对值的最大值


     */


    public static int minOps(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }

        int size = arr.length;
        int sum = 0;
        for(int i = 0 ; i < size ; i++){
            sum += arr[i];
        }

        if(sum % size != 0){
            return -1;
        }

        int avg = sum / size;
        int leftSum = 0; // 左侧一共需要的数量
        int ans = 0;

        for(int i = 0 ; i < arr.length ; i++){
            // 负数， 需要输入，  正数， 需要输出
            int leftRest = leftSum - i * avg;
            // 负数， 需要输入，  正数， 需要输出
            int rightRest = (sum - leftSum - arr[i]) - (size - i - 1) * avg;

            // 左右两边都是负数 ， 中间位置需要扔出去衣服 左侧的绝对值 + 右侧的绝对值
            if(leftRest < 0 && rightRest < 0){
                ans = Math.max(ans , Math.abs(leftRest) + Math.abs(rightRest));
            }else{
                ans = Math.max(ans , Math.max(Math.abs(leftRest) , Math.abs(rightRest)));
            }
            leftSum += arr[i];

        }

        return ans;
    }





}
