package com.song.simple;

import java.util.Arrays;

/**
 * Created by Zhihong Song on 2021/1/20 8:36
 */

public class _628 {


    public int maximumProduct(int[] nums) {
        int len = nums.length;
        if(len < 3){
            return -1;
        }
        Arrays.sort(nums);
        int temp1 = nums[len - 1] * nums[len - 2] * nums[len -3];
        int temp2 = nums[0] * nums[1] * nums[len - 1];
        return temp1 > temp2 ? temp1 : temp2;
    }


    public static void main(String[] args){
        _628 obj = new _628();
        int[] nums = {-100,-98,-1,2,3,4};
        System.out.println(obj.maximumProduct(nums));
    }



}
