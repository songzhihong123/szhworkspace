package com.song.simple;/**
 * Created by Zhihong Song on 2021/4/22 9:48
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: let_code
 * @description:
 * @author: szh
 * @create: 2021-04-22 09:48
 **/
public class _26 {


    public int removeDuplicates2(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int fast = 1;
        int last = 1;
       while(fast < len){
           if(nums[fast] != nums[fast - 1]){
                nums[last] = nums[fast];
                last ++;
           }
           fast ++;
       }
       return last;
    }

    public int removeDuplicates1(int[] nums) {
        int len = nums.length;
        int pointer = 1;
        for (int i = 1; i < len; i++) {
            if(nums[i] != nums[i - 1]){
                nums[pointer++] = nums[i];
            }
        }
        return pointer;
    }

    //垃圾
    public int removeDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        int pointer = 0;
        for (int i = 0; i < len; i++) {
            if(list.contains(nums[i])){
                continue;
            }else {
                nums[pointer++] = nums[i];
                list.add(nums[i]);
            }
        }
        return pointer;
    }

    public static void main(String[] args){
        _26 obj = new _26();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(obj.removeDuplicates2(nums));
    }

}
