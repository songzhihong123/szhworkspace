package com.letcode.szh.simple;

/**
 * @ClassName _485
 * @Description _485
 * @Author szh
 * @Date 2023年11月15日
 */
public class _485 {



    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int res = 0;
        for(int i = 0 ; i < nums.length ; i ++){
           if(nums[i] == 1){
               count ++;
           }else{
               res = Math.max(count , res);
               count = 0;
           }
        }
        res = Math.max(count , res);
        return res;
    }

    public int findMaxConsecutiveOnes1(int[] nums) {
        int res = 0;
        int start = 0;

        for(int i = 0 ; i < nums.length ; i ++){
            if(nums[i] == 1){
                start = i;
            }else{
                continue;
            }
            int end = start + 1;
            while(end < nums.length && nums[end] == 1){
                end ++;
            }
            res = Math.max(res , end - start);

        }

        return res;
    }


    public int findMaxConsecutiveOnes2(int[] nums) {
        int res = 0;
        int start = 0;
        int end = 0;// 6
        while(end < nums.length){
            if(nums[end++] == 0){
                res = Math.max(res , end - start - 1);
                start = end;
            }
        }
        return Math.max(res , end - start);
    }


    public static void main(String[] args) {
        _485 obj = new _485();
//        int[] nums = {1,1,0,1,1,1};
        int[] nums = {1,0,1,1,1,0};
        int count = obj.findMaxConsecutiveOnes2(nums);
        System.out.println(count);
    }



}
