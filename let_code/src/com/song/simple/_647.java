package com.song.simple;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Zhihong Song on 2021/1/24 10:40
 */

public class _647 {

    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        int res = 0;
        int start = 0;
        for (int i = 0; i < len; i++) {
            if(i > 0 && nums[i] <= nums[i -1]){
                start = i;
            }
            res = Math.max(res,i - start + 1);
        }
        return res;
    }





    public static void main(String[] args){
        _647 obj = new _647();
        int[] nums = {1,3,5,4,7};

//        int[] nums = {2,2,2,2,3};
        System.out.println(obj.findLengthOfLCIS(nums));

    }

}
