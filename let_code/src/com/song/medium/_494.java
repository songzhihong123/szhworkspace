package com.song.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-07 09:29
 **/
public class _494 {

    //动态规划 : 以我的能力有点难以理解，多看几次题解就稍微理解一点
    // 下次遇到还得看题解
    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int diff = sum - target;
        if(diff < 0 || diff % 2 != 0){
            return 0;
        }
        int n = nums.length;
        int neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n ; i++) {
            int num = nums[i -1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j >= num){
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
       return dp[n][neg];
    }




    int counter = 0;

    // 回溯法，妙哉，遇到这种问题要想到回溯
    public int findTargetSumWays1(int[] nums, int target) {
        backtrack(nums , target , 0 , 0);
        return counter;
    }

    public void backtrack(int[] nums , int target , int index , int sum){
        if(index == nums.length){
            if(sum == target){
                counter ++;
            }
        }else {
            backtrack(nums , target , index + 1 , sum + nums[index]);
            backtrack(nums , target , index + 1 , sum - nums[index]);
        }
    }




    //暴力：超出时间限制
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer , List<Integer>> map = new HashMap<>();
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        if(len != 0){
            int first = nums[0];
            list.add(first);
            list.add(-first);
            map.put(0,list);
            for (int i = 1; i < len; i++) {
                List<Integer> tempList = new ArrayList<>();
                List<Integer> beforeList = map.get(i - 1);
                int current = nums[i];
                beforeList.forEach(e -> {
                    tempList.add(e - current);
                    tempList.add(e + current);
                });
                map.put(i , tempList);
            }
            List<Integer> lastList = map.get(len - 1);
            int count = (int)lastList.stream().filter(e -> e == target).count();
            return count;
        }
        return 0;
    }


    public static void main(String[] args){
        _494 obj = new _494();
        int [] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(obj.findTargetSumWays2(nums, target));

    }


}
