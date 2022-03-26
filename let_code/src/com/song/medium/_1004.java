package com.song.medium;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-20 18:22
 **/
public class _1004 {


    //P[right]−P[left−1]≤k   ==>   P[left−1]≥P[right]−k
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int[] P = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            P[i] = P[i - 1] + (1 - nums[i - 1]);
        }
        int ans = 0;
        for (int right = 0; right < n; right++) {
            int left = binarySearch(P , P[right + 1] - k);
            ans = Math.max(ans , right - left + 1);
        }
        return ans;
    }

    public int binarySearch(int[] P , int target){
        int low = 0 ;
        int high = P.length - 1;
        while(low < high){
            int middle = low + (high - low) / 2;
            if(P[middle] < target){
                low = middle + 1;
            }else {
                high = middle;
            }
        }
        return low;
    }

    // 滑动窗口
    public int longestOnes1(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int lsum = 0;
        int rsum = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            rsum += 1 - nums[right];
            while(lsum < rsum - k){
                lsum += 1- nums[left];
                ++ left;
            }
            ans = Math.max(ans , right - left + 1);
        }
        return ans;
    }


    public static void main(String[] args){
        _1004 obj = new _1004();
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(obj.longestOnes1(nums , k));
    }



}
