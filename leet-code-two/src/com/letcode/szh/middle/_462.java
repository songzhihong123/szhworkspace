package com.letcode.szh.middle;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ClassName _462
 * @Description _462
 * @Author szh
 * @Date 2023年12月11日
 */
public class _462 {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        // 1 2 9 10
        // 0 0 1 6 8
        int middle = (nums.length + 0) / 2;

        int res = 0 ;

        for (int num : nums){
            res += Math.abs(num - nums[middle]);
        }

        return res;
    }




    public static void main(String[] args) {

        _462 obj = new _462();

//        int[] nums = {1,10,2,9};

//        int[] nums = {1, 2 ,3};

        // 4
        int[] nums = {1,0,0,8,6};

        int res = obj.minMoves2(nums);

        System.out.println("res: " + res);

    }



}
