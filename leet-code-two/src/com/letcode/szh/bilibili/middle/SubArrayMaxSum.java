package com.letcode.szh.bilibili.middle;

/**
 * @ClassName SubArrayMaxSum
 * @Description SubArrayMaxSum
 * @Author szh
 * @Date 2024年01月14日
 */
public class SubArrayMaxSum {


    /*

    给定一个数组, 求该数组的子数组的 最大子数组累加和·


     */

    public static int maxSum(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int curr = 0;

        for(int i = 0 ; i < arr.length ; i ++){
            curr += arr[i];
            max = Math.max(curr , max);
            curr = curr < 0 ? 0 : curr;
        }

        return max;
    }


    public static int maxSum1(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }

        int res = Integer.MIN_VALUE;
        int[] dp = new int[arr.length];
        dp[0] = arr[0];

        for(int i = 1 ; i < arr.length ; i ++){
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            res = Math.max(dp[i] , res);

        }

        return dp[arr.length - 1];
    }




    public static void main(String[] args) {
        int[] arr = {-2 , -3 , -5 , 40 , -10 , -10 , 100 , 1};
        System.out.println(maxSum(arr));
        System.out.println(maxSum1(arr));
    }

}
