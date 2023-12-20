package com.letcode.szh.simple;

/**
 * @ClassName _35
 * @Description _35
 * @Author szh
 * @Date 2023年12月19日
 */
public class _35 {


    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while (left <= right){
            int middle = left + (right - left) / 2;
            if(nums[middle] == target){
                return middle;
            }else if(nums[middle] > target){
                right = middle - 1;
            }else if(nums[middle] < target){
                left = middle + 1;
            }
        }


        return left;
    }


    public int searchInsert1(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int res = n;
        while (left <= right){
            int middle = left + (right - left) / 2;
            if(nums[middle] < target){
                left = middle + 1;
            }else{
                right = middle - 1;
                res = middle;
            }
        }


        return res;
    }


    public static void main(String[] args) {
        _35 obj = new _35();
        int[] nums = {1 , 3 , 5 , 6};
        int target = 2;

        int i = obj.searchInsert1(nums, target);

        System.out.println(i);

    }




}
