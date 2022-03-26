package com.song.simple;

/**
 * Created by Zhihong Song on 2021/2/7 14:59
 */

public class _665 {

    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int x = nums[i];
            int y = nums[i + 1];
            if(x > y){
                nums[i] = y;
                if(isSorted(nums)){
                    return true;
                }
                nums[i] = x;
                nums[i + 1] = x;
                return isSorted(nums);
            }
        }
        return true;
    }

    private boolean isSorted(int[] nums){
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if(nums[i - 1] > nums[i]){
                return false;
            }
        }
        return true;
    }



    public boolean checkPossibility1(int[] nums) {
        int len = nums.length;
        int cnt = 0;
        for (int i = 0; i < len - 1; i++) {
           int x = nums[i];
           int y = nums[i + 1];
           if(x > y){
               cnt ++;
               if(cnt > 1){
                   return false;
               }
               if(i > 0 && y < nums[i - 1]){
                    nums[i + 1] = x;
               }
           }
        }
        return true;
    }


    public static void main(String[] args){
        _665 obj = new _665();
        int[] nums = {2,4,1};
        System.out.println(obj.checkPossibility1(nums));
    }

}
