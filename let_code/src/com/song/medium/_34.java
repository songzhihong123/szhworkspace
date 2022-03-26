package com.song.medium;

public class _34 {


    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1 , -1};
        }
        if(nums.length == 1){
            if(nums[0] != target){
                return new int[]{-1 , -1};
            }else{
                return new int[]{0 , 0};
            }

        }
        int start = 0;
        int end = nums.length - 1;

        while(start < end){

            if(nums[start] != target){
                start ++;
            }

            if(nums[end] != target){
                end --;
            }

            if(nums[start] == nums[end] && nums[start] == target){
                return new int[]{start , end};
            }
        }

        return new int[]{-1 , -1};
    }






    public static void main(String[] args){
        _34 obj = new _34();
        int[] nums = {1};
        int target = 1;

        int[] ints = obj.searchRange(nums, target);
        for(int i: ints){
            System.out.println(i);
        }

    }







}
