package com.letcode.szh.bilibili.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName SubvalueEqualK
 * @Description SubvalueEqualK
 * @Author SubvalueEqualK
 * @Date 2024年01月11日
 */
public class SubvalueEqualK {


    /*

    给定一个数组arr ， 求差值为k的去重数字对

     */


    public static List<List<Integer>> allPair(int[] arr , int k){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < arr.length ; i ++) {
            set.add(arr[i]);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(Integer cur : arr){
            if(set.contains(cur + k)){
                res.add(Arrays.asList(cur , cur + k));
            }
        }

        return  res;
    }




}
