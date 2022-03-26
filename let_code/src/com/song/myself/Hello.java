package com.song.myself;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Zhihong Song on 2021/4/8 18:56
 */

public class Hello {


    //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。

    public List twoSum(int[] nums, int target){
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(nums[i] + nums[j] == target && i != j){
                    list.add(i);
                    list.add(j);
                }
            }
        }
        return list;
    }

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }




}
