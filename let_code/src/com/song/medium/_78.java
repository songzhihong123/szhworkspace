package com.song.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-16 16:21
 **/
public class _78 {

    // 1.
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> subset : result) {
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(num);
                newSubsets.add(newSubset);
            }
            result.addAll(newSubsets);
        }
        return result;
    }

    // 2.
    public List<List<Integer>> subsets1(int[] nums) {
        return recurse(nums.length , nums);
    }
    // 返回前cur个数的所有子集 [1,2,3]
    public List<List<Integer>> recurse(int cur , int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        if(cur == 0){
            result.add(new ArrayList<>());
            return result;
        }

        List<List<Integer>> recurse = recurse(cur - 1, nums);
        result.addAll(recurse);
        for (List<Integer> list : recurse) {
            List<Integer> newSubject = new ArrayList<>(list);
            newSubject.add(nums[cur - 1]);
            result.add(newSubject);
        }
        return result;
    }

    // 3. 回溯
    List<List<Integer>> result = new ArrayList<>();
    int n;

    public List<List<Integer>> subsets2(int[] nums) {
        n = nums.length;
        for (int k = 0; k <= n; k++) {
            backtrack(0 , k , new ArrayList<>() , nums);
        }
        return result;
    }

    public void backtrack(int start , int k , List<Integer> cur , int[] nums){
        if(k == 0){
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < n; i++) {
            cur.add(nums[i]);
            backtrack(i + 1 , k - 1 , cur , nums);
            cur.remove(cur.size() - 1);
        }
    }


    public static void main(String[] args){
        _78 obj = new _78();
        int[] nums = {1, 2, 3};
        System.out.println(obj.subsets1(nums));
    }


}
