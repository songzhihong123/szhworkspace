package com.song.simple;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-16 09:26
 **/
public class _1863 {

    // 我们用函数 dfs(val,idx) 来递归枚举数组 nums 的子集。
    // 其中 val 代表当前选取部分的异或值，idx 代表递归的当前位置。


    int res = 0;

    // {3,4,5,6};
    public void dfs(int[] nums , int idx , int val){
        if(idx == nums.length){
            res += val;
            return;
        }

        //考虑选择当前数字
        dfs(nums , idx +1 , val ^ nums[idx]);

        // 考虑不选择当前数字
        dfs(nums , idx + 1 , val);

    }

    public int subsetXORSum(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        dfs(nums , 0 , 0);
        return res;
    }

    public static void main(String[] args) {
        _1863 obj = new _1863();
        int[] nums = {3, 4, 5};
        System.out.println(obj.subsetXORSum(nums));
    }


    }
