package com.song.simple;

public class _283 {

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        while(right < len){
            if(nums[right] != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left ++;
            }
            right ++;
        }
    }



    public static void main(String[] args){
        _283 obj = new _283();
        int[] nums = {0,1,0,3,0,12};
        obj.moveZeroes(nums);


    }


}
