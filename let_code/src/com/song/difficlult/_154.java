package com.song.difficlult;

/**
 * Created by Zhihong Song on 2021/4/9 9:26
 */

public class _154 {

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(nums[mid] < nums[high]){
                high = mid;
            }else if(nums[mid] > nums[high]){
                low = mid + 1;
            }else{
                high --;
            }
        }
        return nums[low];
    }


    public static void main(String[] args){
        _154 obj = new _154();
        int[] nums = {3,3,1,2};
        System.out.println(obj.findMin(nums));
    }

}
