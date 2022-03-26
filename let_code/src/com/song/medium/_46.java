package com.song.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-17 17:59
 **/
public class _46 {

    List<List<Integer>> result = new ArrayList<>();
    int n;

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        List<Integer> curr = new ArrayList<>();
        for (int num : nums) {
            curr.add(num);
        }
        backPermute(0, curr);
        return result;
    }

    //回溯法
    public void backPermute(int first , List<Integer> curr){
        if(first == n){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = first ; i < n; i ++){
            Collections.swap(curr, first , i);
            backPermute(first + 1 , curr);
            Collections.swap(curr , first , i);
        }

    }


    public static void main(String[] args){
        _46 obj = new _46();
        int[] nums = {1,2,3};
        System.out.println(obj.permute(nums));
    }



}
