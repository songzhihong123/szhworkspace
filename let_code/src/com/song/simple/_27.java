package com.song.simple;/**
 * Created by Zhihong Song on 2021/4/19 8:54
 */

import java.util.Arrays;

/**
 * @program: let_code
 * @description:
 * @author: szh
 * @create: 2021-04-19 08:54
 **/
public class _27 {

    public int removeElement(int[] nums, int val) {
        int size = 0;
        for(int num : nums){
            if(num != val){
                nums[size++] = num;
            }
        }

        return size;
    }

    public int removeElement1(int[] nums, int val) {
        int len = nums.length;
        int left = 0;
        for (int right = 0; right < len; right++) {
            if(nums[right]  != val){
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args){
        _27 obj = new _27();
//        int[] nums = {3,2,2,3};
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(obj.removeElement1(nums, val));
    }


}
