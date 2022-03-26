package com.song.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: szh
 * @create: 2021-06-02 16:54
 **/
public class _523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        int m = nums.length;
        if(m < 2){
            return false;
        }
        // 哈希表存储的是每个余数第一次出现的下标
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int remainder  = 0;
        for (int i = 0; i < m; i++) {
            //((23 % 6) + 2) % 6 等同于
            //(23 + 2) % 6
            // FIXME 数学文化博大而精深 奈何本人没有文化，一句 “卧槽” 走天下
            remainder  = (remainder + nums[i]) % k;
            if(map.containsKey(remainder)){
                int index = map.get(remainder);
                if(i - index >= 2){
                    return true;
                }
            }else {
                map.put(remainder, i);
            }
        }
        return false;
    }

    public static void main(String[] args){
        _523 obj = new _523();
        int[] nums = {23,2,4,6,7};
        int k = 6;
        System.out.println(obj.checkSubarraySum(nums, k));
    }


}
