package com.song.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Zhihong Song on 2021/4/7 13:50
 */

public class _81 {



    public boolean search1(int[] nums, int target) {
        nums = Arrays.stream(nums).distinct().toArray();
        int n = nums.length;
        if(n == 0){
            return false;
        }
        for (int i = 0; i < n; i++) {
            if(nums[i] == target){
                return true;
            }
        }
        return false;
    }


    public boolean search(int[] nums, int target) {
        nums = Arrays.stream(nums).distinct().toArray();
        int n = nums.length;
        if(n == 0){
            return false;
        }
        if(n == 1){
            return nums[0] == target ? true : false;
        }
        int l = 0;
        int r = n - 1;
        while (l <= r){
            int mid = (l + r) / 2 ;
            if(nums[mid]  == target){
                return true;
            }
            if(nums[0] <= nums[mid]){
                if(nums[0] <= target && target < nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{
                if(nums[mid] < target && target <= nums[n - 1]){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = {2,5,6,0,0,1,2};
        int target = 0;
        _81 obj = new _81();
        System.out.println(obj.search(nums, target));
    }


}
