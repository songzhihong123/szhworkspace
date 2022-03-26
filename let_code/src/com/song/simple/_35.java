package com.song.simple;

public class _35 {


    public int searchInsert(int[] nums, int target) {
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
        return left;
    }


    public static void main(String[] args){
        _35 obj = new _35();
        int [] nums = {1,3,5,6};
        int target = 5;
        System.out.println(obj.searchInsert(nums, target));


    }


}
