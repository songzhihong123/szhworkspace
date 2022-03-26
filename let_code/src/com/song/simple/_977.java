package com.song.simple;

public class _977 {

    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            nums[i] = nums[i] * nums[i];
        }
        for (int i = 0; i < len ; i++) {
            for (int j = 0; j < len - i -1; j++) {
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    public int[] sortedSquares1(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0 , j = n - 1 , pos = n - 1 ; i <= j ;){

            if(nums[i] * nums[i] > nums[j] * nums[j]){
                res[pos] = nums[i] * nums[i];
                i ++;
            }else{
                res[pos] = nums[j] * nums[j];
                j --;
            }
            pos --;

        }
        return res;
    }



    public static void main(String[] args){
        _977 obj = new _977();
        int[] nums = {-5,-3,-2,1};
        int[] res = obj.sortedSquares1(nums);
        for (int r : res){
            System.out.println(r);
        }
    }


}
