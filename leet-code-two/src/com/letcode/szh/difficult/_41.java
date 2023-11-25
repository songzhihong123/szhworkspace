package com.letcode.szh.difficult;

/**
 * @ClassName _41
 * @Description _41
 * @Author szh
 * @Date 2023年11月25日
 */
public class _41 {



    // 1 : 用数据的下标作为hash表的key值 ， 用正负数来标识是否出现过
    // 2: 把对应的位置的数放回原有的位置上面

    // 实际上，对于一个长度为 N 的数组，其中没有出现的最小正整数只能在 [1,N+1] 中
    // 用数据的下标作为hash表的key值
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        // 3,4,-1,1
        for(int i = 0 ; i < n ; i ++){
            if(nums[i] <= 0){
                nums[i] = n + 1;
            }
        }


        for(int i = 0 ; i < n ; i ++){
            int x = Math.abs(nums[i]);
            if(x <= n){
                nums[x - 1] = -Math.abs(nums[x - 1]);
            }
        }

        for(int i = 0 ; i < n ; i ++){
            if(nums[i] > 0){
                return i + 1;
            }
        }

        return n + 1;
    }



    public int firstMissingPositive1(int[] nums) {

        int n = nums.length;

        // 3,4,-1,1
        for(int i = 0 ; i < n ; i ++){
            if(nums[i] <= 0){
                nums[i] = n + 1;
            }
        }

        for(int i = 0 ; i < n ; i ++){

            while(nums[i] <= n && nums[i] != nums[nums[i] - 1]){
                swap(nums , i  , nums[i] - 1);
            }
        }


        for(int i = 0 ; i < n ; i ++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }

        return n + 1;
    }

    private void swap(int[] nums , int index1 , int index2){
        int tem = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tem;
    }


    public static void main(String[] args) {
        _41 obj = new _41();

        int[] nums = {1,2,0};

//        int[] nums = {3,4,-1,1};

//        int[] nums = {7,8,9,11,12};

        System.out.println(obj.firstMissingPositive1(nums));

    }

}
