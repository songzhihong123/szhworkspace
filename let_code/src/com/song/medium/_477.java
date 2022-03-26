package com.song.medium;

/**
 * @description:
 * @author: szh
 * @create: 2021-05-28 09:37
 **/
public class _477 {

    public int totalHammingDistance(int[] nums) {
        int ret = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                ret += hammingDistance(nums[i] , nums[j]);
            }
        }
        return ret;
    }

    private int hammingDistance(int x , int y){
        int z = x ^ y;
        int ret = 0;
        while(z != 0){
            z &= z - 1;
            ret ++;
        }
        return ret;
    }

    public int totalHammingDistance1(int[] nums) {
        int ret = 0;
        int len = nums.length;
        for (int i = 0; i < 30; i++) {
            int c = 0;
            for(int num : nums){
                c += (num >> i) & 1;
            }
            ret += c * (len - c);
        }
        return ret;
    }

    public static void main(String[] args){
        _477 obj = new _477();
        int[] nums = {4, 14, 2};
        System.out.println(obj.totalHammingDistance1(nums));
        System.out.println(1^4^7);
    }


}
