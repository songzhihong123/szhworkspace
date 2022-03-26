package com.song.medium;/**
 * Created by Zhihong Song on 2021/4/23 17:36
 */

/**
 * @program: let_code
 * @description:
 * @author: szh
 * @create: 2021-04-23 17:36
 **/
public class _11 {

    /**
     * 双指针
     *
     **/

    public int maxArea1(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int ans = 0;
        while(l < r){
            int area = Math.min(height[l] , height[r]) * (r - l);
            ans = Math.max(ans,area);
            if(height[l] < height[r]){
                l ++;
            }else {
                r --;
            }
        }
        return ans;
    }





    /**
     *
     * 动态规划可以实现么？
     * dp[i] 表示下标为i的时候水位的最大值
     * 有问题 没有考虑到 1 2 1 的情况
     **/
    @Deprecated
    public int maxArea(int[] height) {
        int len = height.length;
        int[] dp = new int[len];
        dp[0] = 0;
        int maxValue =height[0];
        int maxIndex = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i - 1] , (i - maxIndex) * Math.min(maxValue , height[i]) + dp[maxIndex]);
            }
            if(height[i] > maxValue){
                maxValue = height[i];
                maxIndex = i;
            }
        }
        return dp[len - 1];
    }


    public static void main(String[] args){
        _11 obj = new _11();
        int[] height = {1,8,6,2,5,4,8,3,7};
//        int[] height = {1,2,1};
        System.out.println(obj.maxArea1(height));
    }

}
