package com.song.simple;

/**
 * Created by Zhihong Song on 2021/2/9 14:48
 */

public class _643 {


    public double findMaxAverage(int[] nums, int k) {
        int res = Integer.MIN_VALUE;
        for (int i = k - 1; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j >= i - k + 1; j--) {
                temp += nums[j];
            }
            res = Math.max(res,temp);
        }
        return (double)res/k;
    }


    public double findMaxAverage1(int[] nums, int k) {
        int res = Integer.MIN_VALUE;
        int len = nums.length;
        int left = 0;
        int right = 0;
        int temp = 0;
        while(right < len){
            while(right <= k - 1){
                temp += nums[right];
                right ++;
            }
            res = Math.max(temp,res);
            if(right < len){
                temp = temp - nums[left] + nums[right];
                right ++;
                left ++;
                res = Math.max(temp,res);
            }
        }
        return (double)res/k;
    }




    public static void main(String[] args){
        _643 obj = new _643();
        int[] nums = {0,1,1,3,3};
        int k = 4;
        System.out.println(obj.findMaxAverage1(nums, k));
    }


}
