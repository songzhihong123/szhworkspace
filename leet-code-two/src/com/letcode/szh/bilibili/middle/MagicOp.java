package com.letcode.szh.bilibili.middle;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @ClassName MagicOp
 * @Description MagicOp
 * @Author szh
 * @Date 2024年01月11日
 */
public class MagicOp {


    /*

        给一个包含n个正数元素集合a ， 一个包含m个元素的饿集合b。
        定义magic操作为， 从一个集合中取出一个元素，放到另一个
        集合中，且操作过后每个集合的平均值都大于操作前。

        注意：
            1、不可以把一个集合的元素取空
            2、值为x的元素从集合b取出放入集合a，但是a中已经有值为x
            的元素，则a的平均值不变（因为集合元素不会重复），b的平均值
            肯呢个会改变（因为x被取出了）

         问最多可以进行多少次magic操作？

     */

    public static int maxOps(int[] arr1 , int[] arr2){
        double sum1 = 0;
        for(int i = 0 ; i < arr1.length ; i ++){
            sum1 += (double) arr1[i];
        }

        double sum2 = 0;
        for(int i = 0 ; i < arr2.length ; i ++){
            sum2 += (double) arr2[i];
        }

        // 如果两个数组的平均值一样，则怎么操作页不会让两个集合的平均值增大
        if(avg(sum1 , arr1.length) == avg(sum2 , arr2.length)){
            return 0;
        }

        // 让两个集合平均值增大的方式就是把平均值大的集合的数字往平均值小的集合中放

        int[] arrMore = null;
        int[] arrLess = null;
        double sumMore = 0;
        double sumLess = 0;

        if(avg(sum1 , arr1.length) > avg(sum2 , arr2.length)){
            arrMore = arr1;
            arrLess = arr2;
            sumMore = sum1;
            sumLess = sum2;
        }else{
            arrMore = arr2;
            arrLess = arr1;
            sumMore = sum2;
            sumLess = sum1;
        }
        // 排序
        Arrays.sort(arrMore);
        HashSet<Integer> setLess = new HashSet<>();
        for(int num : arrLess){
            setLess.add(num);
        }

        int moreSize = arrMore.length; // 平均值大的集合还剩几个数
        int lessSize = arrLess.length; // 平均值小的集合还剩几个数

        int ops = 0;

        for(int i = 0 ; i < arrMore.length ; i++){
            double cur = (double) arrMore[i];
            // 当前数字是必须在最小平均值和最大平均值之间 并且 平均值较小中的集合不包含当前数字
            if(cur < avg(sumMore , moreSize) && cur > avg(sumLess , lessSize)
                && !setLess.contains(arrLess[i])){
                sumMore -= cur;
                sumLess += cur;
                moreSize --;
                lessSize ++;
                setLess.add(arrMore[i]);
                ops ++;
            }
        }


        return ops;
    }



    public static double avg(double sum , int length){
        return (double) sum / length;
    }




}
