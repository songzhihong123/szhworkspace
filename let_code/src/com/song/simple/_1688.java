package com.song.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-17 14:58
 **/
public class _1688 {

    public int numberOfMatches(int n) {
        int res = 0;
        while (n != 1){
            if(n % 2 == 0){
                n = n / 2;
                res += n;
            }else{
                res += (n - 1) / 2;
                n = (n - 1) / 2 + 1;
            }
        }
        return res;
    }



    public static void main(String [] args){
        _1688 obj = new _1688();
//        int n = 7;
//        System.out.println(obj.numberOfMatches(n));
        int[] nums = {1,2,3};
        System.out.println(obj.subsets1(nums));
    }


    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> subList = new ArrayList<>();
            for (List<Integer> list : result) {
                List<Integer> newSubList = new ArrayList<>(list);
                newSubList.add(num);
                subList.add(newSubList);
            }
            result.addAll(subList);
        }
        return result;
    }




    List<List<Integer>> result = new ArrayList<>();
    int n;

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        for (int k = 0; k <= n; k++) {
            backSubsets(0 , k , new ArrayList<>() ,nums);
        }
        return result;
    }

    public void backSubsets(int start , int k , List<Integer> curr , int[] nums){
        if(k == 0){
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i < n; i++) {
            curr.add(nums[i]);
            backSubsets(i + 1 , k - 1 , curr , nums);
            curr.remove(curr.size() - 1);
        }
    }



}
