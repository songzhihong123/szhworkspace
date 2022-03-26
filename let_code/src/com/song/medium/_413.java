package com.song.medium;

public class _413 {

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return 0;
        }
        int d = nums[0] - nums[1];
        int t = 0;
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if(nums[i - 1] - nums[i] == d){
                t ++;
            }else{
                d = nums[i - 1] - nums[i];
                t = 0;
            }
            ans += t;
        }
        return ans;
    }

    public int numberOfArithmeticSlices1(int[] nums) {
        int n = nums.length;
        if(n <= 2){
            return 0;
        }
        int ans = 0;
        int dp = 0;
        for (int i = 2; i < n; i++) {
           if(nums[i] - nums[i -1] == nums[i - 1] - nums[i - 2]){
               dp ++;
           } else{
               dp = 0;
           }
           ans += dp;
        }

        return ans;
    }




    public static void main(String[] args){
        _413 obj = new _413();
        int[] nums = {1,2,3,4};
        System.out.println(obj.numberOfArithmeticSlices1(nums));
    }



}
