package com.letcode.szh.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName _442
 * @Description _442
 * @Author szh
 * @Date 2023年11月25日
 */
public class _442 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int n = nums.length;

        for(int i = 0 ; i < n ; i ++){
            while(nums[i] != nums[nums[i] - 1]){
                swap(nums , i , nums[i] - 1);
            }
        }

        for(int i = 0 ; i < n ; i ++ ){
            if(nums[i] - 1 != i){
                result.add(nums[i]);
            }
        }

        return result;
    }

    private void swap(int[] nums , int index1 , int index2){
        int tem = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tem;
    }



    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for(int i = 0 ; i < n ; i ++){
            int x = Math.abs(nums[i]);
            if(nums[x - 1] > 0){
                nums[x - 1] = -nums[x - 1];
            }else{
                result.add(x);
            }
        }
        return result;
    }



    public static void main(String[] args) {
        _442 obj = new _442();

        int[] nums = {4,3,2,7,8,2,3,1};

        obj.findDuplicates1(nums).forEach(System.out::println);

    }


}
