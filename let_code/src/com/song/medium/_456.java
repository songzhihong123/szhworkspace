package com.song.medium;

import java.util.TreeMap;

/**
 * Created by Zhihong Song on 2021/3/24 9:13
 */

public class _456 {




    public boolean find132pattern1(int[] nums){
        int n = nums.length;
        if(n < 3){
            return false;
        }
        int leftMin = nums[0];
        TreeMap<Integer,Integer> rightAll = new TreeMap<>();
        for (int i = 2; i < n; i++) {
            rightAll.put(nums[i],rightAll.getOrDefault(nums[i],0) + 1);
        }
        for (int i = 1; i < n - 1; i++) {
            if(leftMin < nums[i]){
                Integer next = rightAll.ceilingKey(leftMin + 1);
                if(next != null && next < nums[i]){
                    return true;
                }
            }
            leftMin = Math.min(leftMin , nums[i]);
            rightAll.put(nums[i + 1],rightAll.get(nums[i + 1]) - 1);
            if(rightAll.get(nums[i + 1]) == 0){
                rightAll.remove(nums[i + 1]);
            }
        }
        return false;
    }





    /**
     * 暴力解法，超时了
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        if(len < 3){
            return false;
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    int[] temp = new int[3];
                    temp[0] = nums[i];
                    temp[1] = nums[k];
                    temp[2] = nums[j];
                    if(checkArrSortDesc(temp)){
                        return true;
                    }
                }
            }

        }

        return false;
    }

    private boolean checkArrSortDesc(int target[]){
        int len = target.length;
        for (int i = 1; i < len; i++) {
            if(target[i] <= target[i - 1]){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){
        int nums[] = {1, 2, 1, 4};
        _456 obj = new _456();
        System.out.println(obj.find132pattern1(nums));
    }


}
