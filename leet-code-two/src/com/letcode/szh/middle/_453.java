package com.letcode.szh.middle;

import java.util.Arrays;

/**
 * @ClassName _453
 * @Description _453
 * @Author szh
 * @Date 2023年12月10日
 */
public class _453 {


    public int minMoves(int[] nums) {

        //        int[] nums = {1,2,3};

        int res = 0;
        if(numsAllEquals(nums)){
            return res;
        }

        int n = nums.length;
        int needChange = n - 1;

        do {
            Arrays.sort(nums);
            for (int i = 0; i < needChange; i++) {
                nums[i]++;
            }
            res++;

        } while (!numsAllEquals(nums));

        return res;
    }

    public boolean numsAllEquals(int[] nums){
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] != nums[i - 1]){
                return false;
            }
        }
        return true;
    }



    // 每次操作既可以理解为使 n−1 个元素增加 1，也可以理解使 1 个元素减少 1。
    public int minMoves2(int[] nums) {
        int minValue = Integer.MAX_VALUE;

        for(int num : nums){
            if(num < minValue){
                minValue = num;
            }
        }

        int res = 0;

        for(int num : nums){
            res += num - minValue;
        }

        return res;
    }



    public static void main(String[] args) {

        _453 obj = new _453();

//        int[] nums = {1,2,3};

//        int[] nums = {1,1,1};

        int[] nums =  {1,1000000000};


        int result = obj.minMoves2(nums);

        System.out.println("result: " + result);


    }


}
