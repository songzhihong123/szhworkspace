package com.letcode.szh.simple;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * @ClassName _283
 * @Description _283
 * @Author szh
 * @Date 2023年12月18日
 */
public class _283 {

    public void moveZeroes(int[] nums) {

        // 4,2,4,0,0,3,0,5,1,0
        // 4,2,4,3,5,1,0,0,0,0
        int n = nums.length;

        for(int i = 0 ; i < n ; i ++){
           if(nums[i] != 0){
               continue;
           }
           for(int j = i + 1; j < n ; j ++){
               if(nums[j] != 0){
                   int tem = nums[j];
                   nums[j] = nums[i];
                   nums[i] = tem;
                   break;
               }

           }
        }
    }

    public void moveZeroes1(int[] nums) {
        // 4,2,4,0,0,3,0,5,1,0
        // 4,2,4,3,5,1,0,0,0,0
        for(int i = 0 ; i < nums.length ; i ++){
            if(nums[i] != 0){
                continue;
            }
            int cur = i;
            for(int j = i + 1; j < nums.length ; j ++){
                if(nums[j] != 0){
                    int tem = nums[j];
                    nums[j] = nums[cur];
                    nums[cur] = tem;
                    cur = j;
                }

            }
        }
    }


    public void moveZeroes2(int[] nums) {
        // 4,2,4,0,0,3,0,5,1,0
        // 4,2,4,3,5,1,0,0,0,0

        int leftIndex = 0 ;
        int rightIndex = 0;
        int n = nums.length;

        while (rightIndex < n){
            if(nums[rightIndex] != 0){
                int tem = nums[rightIndex];
                nums[rightIndex] = nums[leftIndex];
                nums[leftIndex] = tem;
                leftIndex ++;
            }
            rightIndex ++;
        }

    }




     public static void main(String[] args){
         _283 obj = new _283();

//         int[] nums = {0,1,0,3,12};

//         int[] nums = {0,0,1};


         int[] nums = {4,2,4,0,0,3,0,5,1,0};



         obj.moveZeroes2(nums);

         for (int num : nums){
             System.out.println(num);
         }


     }


}
