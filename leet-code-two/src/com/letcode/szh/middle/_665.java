package com.letcode.szh.middle;

/**
 * @ClassName _665
 * @Description _665
 * @Author szh
 * @Date 2023年12月17日
 */
public class _665 {


    public boolean checkPossibility(int[] nums) {

        int n = nums.length;

        for(int i = 0 ; i < n - 1; i ++){
            int x = nums[i] ;
            int y = nums[i + 1];
            if(x > y){
               nums[i] = y;
               if(isSorted(nums)){
                   return true;
               }

               nums[i] = x;
               nums[i + 1] = x;

               return isSorted(nums);
            }
        }
        return true;
    }

    public boolean isSorted(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; ++i) {
            if (nums[i - 1] > nums[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        _665 obj = new _665();

//        int[] nums = {4 , 2 , 3};
//        int[] nums = {4,2,1};

//        int[] nums = {3,4,2,3};

        int[] nums = {5 , 7 , 1 , 8 , 1};


        boolean res = obj.checkPossibility(nums);

        System.out.println("res: " + res);
    }

}
