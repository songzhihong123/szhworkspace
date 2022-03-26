package com.song.medium;/**
 * Created by Zhihong Song on 2021/4/23 11:28
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: let_code
 * @description:
 * @author: szh
 * @create: 2021-04-23 11:28
 **/
public class _368 {


    /**
     * 动态规划
     * dp[i] 表示在输入数组 nums 升序排列的前提下，以 nums[i] 为最大整数的「整除子集」的大小
     * （在这种定义下nums[i] 必须被选择）。
     *
     **/


    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[len];
        Arrays.fill(dp , 1);
        //组织dp的数据
        int maxSize = 0;
        int maxValue = dp[0];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            if(dp[i] > maxSize){
                maxSize = dp[i];
                maxValue = nums[i];
            }
        }
        //倒推推出来最大子集
        List<Integer> list = new ArrayList<>();
        if(maxSize == 1){
            list.add(nums[0]);
            return list;
        }
        for (int i = len - 1 ; i >=0 && maxSize > 0; i--) {
            if(dp[i] == maxSize && maxValue % nums[i] == 0){
                list.add(nums[i]);
                maxSize --;
                maxValue = nums[i];
            }
        }
        return list;
    }


    public static void main(String[] args){
        _368 obj = new _368();
        int[] nums = {2,3,4,6,9};
        obj.largestDivisibleSubset(nums).forEach(System.out::println);
    }

}
