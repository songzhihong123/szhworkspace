package com.song.medium;

public class _189 {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0 ; i < n ; i++){
            ans[(i + k) % n] = nums[i];
        }
        System.arraycopy(ans , 0 , nums , 0 , n);
    }


    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        reverse(nums , 0 , len - 1);
        reverse(nums , 0 , k - 1);
        reverse(nums , k  , len - 1);
    }


    public void reverse(int[] nums , int start , int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }


    public static void main(String[] args){
        _189 obj = new _189();
        int[] nums = {-1};
        int k = 2;
        obj.rotate1(nums , k);
    }



}
