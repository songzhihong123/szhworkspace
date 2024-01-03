package com.letcode.szh.bytedance;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName _1
 * @Description 两数之和
 * @Author szh
 * @Date 2024年01月02日
 */
public class _1 {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        for(int i = 0 ; i < nums.length ; i ++){
            res[0] = i;
            for(int j = i + 1 ; j < nums.length; j++){
                if(nums[j] + nums[i] == target){
                    res[1] = j;
                    return res;
                }
            }
        }
        return  res;
    }



    public static void main(String[] args) {
        _1 obj = new _1();
        int[] nums = {2 , 7 , 11 ,15};
        int target = 9;

        int[] ints = obj.twoSum(nums, target);

        for (int i : ints){
            System.out.print(i + " ");
        }

    }


}
