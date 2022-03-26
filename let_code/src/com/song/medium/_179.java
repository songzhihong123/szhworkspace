package com.song.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Zhihong Song on 2021/4/12 9:36
 */

public class _179 {

    // 自己写的 ，垃圾 ， tmd ， 字符串排序就tm想不到 ，蠢材
    public String largestNumber(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        if (nums[0] == 0 && nums[len - 1] == 0){
            return "0";
        }
        Map<String, List<String>> struct = new HashMap<>();
        for(int num : nums){
            String key = String.valueOf(String.valueOf(num).charAt(0));
            if(struct.containsKey(key)){
                struct.get(key).add(String.valueOf(num));
            }else{
                struct.put(key,new ArrayList<>());
                struct.get(key).add(String.valueOf(num));
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 9; i >= 0 ; i --) {
            if(struct.containsKey(String.valueOf(i))){
                List<String> list = struct.get(String.valueOf(i));
                if(list.size() == 1){
                    builder.append(list.get(0));
                    continue;
                }
                list.stream().sorted((a ,b) -> (b + a).compareTo(a + b)).forEach(str -> builder.append(str));
            }
        }
        return builder.toString();
    }


    public String largestNumber1(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        if (nums[0] == 0 && nums[len - 1] == 0){
            return "0";
        }
        String[] strings = new String[len];
        for (int i = 0; i < len; i++) {
            strings[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strings,(x , y) -> (x + y).compareTo((y + x)));
        StringBuilder builder = new StringBuilder();
        for (int i = len - 1; i >= 0; i--){
            builder.append(strings[i]);
        }
        return builder.toString();
    }

    public static void main(String[] args){
        _179 obj = new _179();
        int[] nums = {0,0};
        System.out.println(obj.largestNumber(nums));

    }



}
