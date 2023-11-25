package com.letcode.szh.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName _645
 * @Description _645
 * @Author szh
 * @Date 2023年11月21日
 */
public class _645 {


    public int[] findErrorNums(int[] nums) {
        Map<Integer , Integer> countMap = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i ++){
            countMap.put(nums[i] , countMap.getOrDefault(nums[i] , 0) + 1);
        }

        int[] res = new int[2];

        for(int i = 1 ; i <= nums.length ; i ++){
            int count = countMap.getOrDefault(i , 0);
            if(count == 0){
                res[1] = i;
            }else if(count == 2){
                res[0] = i;
            }
        }

        return res;
    }

    public int[] findErrorNums1(int[] nums) {

        Arrays.sort(nums);

        int[] res = new int[2];

        int pre = 0 ;

        for(int i = 0 ; i < nums.length ; i ++){
            int curr = nums[i];
            if(curr == pre){
                res[0] = nums[i];
            }else if(curr - pre > 1){
                res[1] = pre + 1;
            }
            pre = curr;
        }

        if(nums[nums.length - 1] != nums.length){
            res[1] = nums[nums.length - 1] + 1;
        }


        return res;
    }


    public static void main(String[] args) {
        _645 obj = new _645();

//        int[] nums = {1,2,2,4};

//        int[] nums = {1,1};

        int[] nums = {2,2};

        int[] errorNums = obj.findErrorNums1(nums);

        Arrays.stream(errorNums).forEach(System.out::println);


    }



}
