package com.letcode.szh.simple;

import java.util.Arrays;

/**
 * @ClassName _628
 * @Description _628
 * @Author szh
 * @Date 2023年11月19日
 */
public class _628 {


    public int maximumProduct(int[] nums) {

        Arrays.sort(nums);

        int a = nums[nums.length - 1] *  nums[nums.length - 2] * nums[nums.length - 3];

        int b = nums[nums.length - 1] * nums[0] * nums[1];


        return Math.max(a , b);
    }


    public int maximumProduct1(int[] nums) {

        // 最大的a , 第二大的b , 第三大的c
        // 最小的d 和第二小的e
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        int c  = Integer.MIN_VALUE;
        int d = Integer.MAX_VALUE;
        int e = Integer.MAX_VALUE;


        for (int num : nums){

            if(num < d){
                e = d;
                d = num;
            }else if(num < e){
                e = num;
            }

            if(num > a){
                c = b;
                b = a;
                a = num;
            }else if(num > b){
                c = b ;
                b = num;
            }else if(num > c){
                c = num;
            }

        }

        int a1 = a * b * c;
        int a2 = a * d * e;


        return Math.max(a1 , a2);
    }




    public static void main(String[] args) {

        _628 obj = new _628();

//        int[] nums = {1 ,2 ,3};

//        int[] nums = {1 ,2 ,3 , 4};

        int[] nums = {-1 , -2 , -3};

        int res = obj.maximumProduct1(nums);

        System.out.println(res);

    }


}
