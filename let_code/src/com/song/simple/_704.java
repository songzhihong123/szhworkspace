package com.song.simple;

public class _704 {


    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int minddle = left + (right - left) / 2;
            if(nums[minddle] == target){
                return minddle;
            }else if(nums[minddle] > target){
                right = minddle - 1;
            }else{
                left = minddle + 1;
            }

        }
        return -1;
    }


    public static void main(String[] args){
        _704 obj = new _704();
        int[] nums = {5};
        int target = 5;
        System.out.println(obj.search(nums, target));
    }



}
