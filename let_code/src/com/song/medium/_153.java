package com.song.medium;

import java.util.Arrays;

/**
 * Created by Zhihong Song on 2021/4/8 9:18
 */

public class _153 {

    public int findMin1(int[] nums) {
        return  Arrays.stream(nums).min().getAsInt();
    }


    public int findMin2(int[] nums) {
        int[] ints = Arrays.stream(nums).sorted().toArray();
        if(ints.length != 0){
            return ints[0];
        }else {
            throw new IllegalArgumentException("params nums size not zero");
        }
    }

    public int findMin3(int[] nums) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            res = Math.min(nums[i] , res);
        }
        return res;
    }


    public int findMin4(int[] nums) {
      int low = 0;
      int high = nums.length - 1;
      while (low < high){
          int mid = low + (high - low) / 2;
          if(nums[mid] < nums[high]){
                high = mid;
          }else{
              low = mid + 1;
          }
      }
      return nums[low];
    }


    public int findMin(int[] nums) {
        int n = nums.length;
        if(n == 0){
            throw new IllegalArgumentException("params nums size not zero");
        }
        if(n == 1){
            return nums[0];
        }
        float left = 0;
        float right = n - 1;
        int res = Integer.MAX_VALUE;
        while(left <= right){
            int mid = (int)Math.ceil((left + right) / 2);
            if(nums[0] < nums[mid]){
                res = Math.min(res,nums[0]);
                left = mid + 1;
            }else {
                res = Math.min(res,nums[mid]);
                right = mid - 1;
            }
        }
        return res;
    }


    public static void main(String[] args){
        _153 obj = new _153();
        int[] nums = {2,2,2,0,1};
        System.out.println(obj.findMin4(nums));

    }




}
