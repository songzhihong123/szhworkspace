package com.letcode.szh.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName _448
 * @Description _448
 * @Author szh
 * @Date 2023年11月24日
 */
public class _448 {


    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();


        int n = nums.length;

        int[] temp = new int[n + 1];

        for (int val : nums) {
            if (val <= n) {
                temp[val] = 1;
            }
        }

        for (int i = 1 ; i <= n ; i++){
            if(temp[i] == 0){
                result.add(i);
            }
        }

        return result;
    }



    public List<Integer> findDisappearedNumbers1(int[] nums) {

        int n = nums.length;

        //  4,3,2,7,8,2,3,1
        for(int num : nums){
            int a = (num - 1) % n;
            nums[a] += n;
        }

        List<Integer> result = new ArrayList<>();

        for(int i = 0 ; i < n ; i ++){
            if(nums[i] <= n){
                result.add(i + 1);
            }
        }

        return result;
    }



    public static void main(String[] args) {
        _448 obj = new _448();

        int[] nums = {4,3,2,7,8,2,3,1};

//        int[] nums = {1 , 1};

        List<Integer> numbers = obj.findDisappearedNumbers1(nums);

        numbers.forEach(System.out::println);


    }


}
