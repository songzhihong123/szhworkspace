package com.song.medium;

/**
 * Created by Zhihong Song on 2021/4/7 13:20
 */

public class _33 {


    public int search1(int[] nums, int target) {
        int n = nums.length;
        if(n == 0){
            return -1;
        }
        for (int i = 0; i < n; i++) {
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }


    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0){
            return -1;
        }
        if(n == 1){
            return nums[0] == target ? 0 : -1;
        }
        int l = 0;
        int r = n - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[0] < nums[mid]){
                if(nums[0] <= target && target < nums[mid]){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }else{
                if(nums[mid] < target && target <= nums[n - 1]){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {0,1,2,4,5,6,7};
        int target = 5;
        _33 obj = new _33();
        System.out.println(obj.search(nums, target));
    }


}
