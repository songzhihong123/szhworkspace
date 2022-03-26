package com.song.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-03 09:52
 **/
public class _525 {


    // 这种题简约而不简单
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        int nLen = nums.length;
        // 哈希表存储每个前缀和第一次出现的下标
        Map<Integer,Integer> map = new HashMap<>();
        int counter = 0;
        map.put(counter , -1);
        for (int i = 0; i < nLen; i++) {
            if(nums[i] == 1){
                counter ++;
            }else {
                counter --;
            }
            if(map.containsKey(counter)){
                int index = map.get(counter);
                maxLength = Math.max(maxLength , i - index);
            }else {
                map.put(counter , i);
            }
        }
        return maxLength;
    }


    public static void main(String[] args){
        _525 obj = new _525();
        int[] nums = {0,1,0};
        System.out.println(obj.findMaxLength(nums));
    }


}
