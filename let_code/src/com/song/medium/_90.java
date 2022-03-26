package com.song.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Zhihong Song on 2021/3/31 14:37
 */

public class _90 {


    /**
     *  1 -> 000
     *  2 -> 001
     *  3 -> 010
     *  4 -> 011
     *  5 -> 100
     *  6 -> 101
     *  7 -> 110
     *  8 -> 111
     *
     *  {1 , 2 , 2}
     */

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> t = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int n = nums.length;
        // 如果有n个数，那么子集数就是2^n的n次方，
        // 枚举 2^n 次  (1 << n)
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            boolean flag = true;
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    // 代码实现时，可以先将数组排序；迭代时， 若发现没有选择上一个数，且当前数字与上一个数相同，则可以跳过当前生成的子集
                    if (i > 0 && (mask >> (i - 1) & 1) == 0 && nums[i] == nums[i - 1]) {
                        flag = false;
                        break;
                    }
                    t.add(nums[i]);
                }
            }
            if (flag) {
                ans.add(new ArrayList<Integer>(t));
            }
        }
        return ans;
    }


    public static void main(String[] args){
        _90 obj = new _90();
        int[] nums = {1,2,2};
        obj.subsetsWithDup(nums);
    }


}
