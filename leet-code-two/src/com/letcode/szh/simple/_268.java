package com.letcode.szh.simple;

/**
 * @ClassName _268
 * @Description _268
 * @Author szh
 * @Date 2023年11月25日
 */
public class _268 {

    public int missingNumber(int[] nums) {

        int n = nums.length;

        for(int i = 0 ; i < n ; i ++){
            if(nums[i] <= 0){
                nums[i] = n + 1;
            }
        }


        for(int i = 0 ; i < n ; i ++){
            int x = Math.abs(nums[i]);
            if(x <= n){
                nums[x - 1] = - Math.abs(nums[x - 1]);
            }
        }

        for(int i = 0 ; i < n ; i ++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return 0;
    }


    public int missingNumber1(int[] nums) {

        int n = nums.length;

        for(int i = 0 ; i < n ; i ++){
            while(nums[i] <= n && nums[i] > 0 && nums[i] != nums[nums[i] - 1]){
                swap(nums , i  , nums[i] - 1);
            }
        }

        for(int i = 0 ; i < n ; i ++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }

        return 0;
    }

    private void swap(int[] nums , int index1 , int index2){
        int tem = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tem;
    }


    public static void main(String[] args) {
        _268 obj = new _268();

        int[] nums = {9,6,4,2,3,5,7,0,1};
//        int[] nums = {3,0,1};

//        int[] nums = {0,1};
//        int[] nums = {0};

//        int[] nums = {1};


        System.out.println(obj.missingNumber1(nums));
    }
}
