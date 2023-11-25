package com.letcode.szh.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName _697
 * @Description _697
 * @Author szh
 * @Date 2023年11月21日
 */
public class _697 {

    public int findShortestSubArray(int[] nums) {

        // 统计个数
        Map<Integer , Integer> countMap = new HashMap<>();

        for(int n : nums){
            countMap.put(n , countMap.getOrDefault( n , 0) + 1);
        }

        // 求最大的度
        int i = 0;

        for(Integer key : countMap.keySet()){
            Integer recordDu = countMap.get(key);
            if(recordDu > i){
                i = recordDu;
            }
        }

        // 最大的度对应的数
        List<Integer> valueList = new ArrayList<>();

        for(Integer key : countMap.keySet()){
            Integer recordDu = countMap.get(key);
            if(recordDu == i){
                valueList.add(key);
            }
        }


        // 最大的数对应起始位置
        Map<Integer , int[]> recordIndexMap = new HashMap<>();


        for(int x = 0 ; x < nums.length ; x ++){
            int v = nums[x];
            if(valueList.contains(v)){
                if(!recordIndexMap.containsKey(v)){
                    recordIndexMap.put(v , new int[]{x , x});
                }else{
                    recordIndexMap.get(v)[1] = x;
                }
            }
        }

        // 求最小值
        int res = Integer.MAX_VALUE;

        for(Integer k : recordIndexMap.keySet()){
            res = Math.min(recordIndexMap.get(k)[1] - recordIndexMap.get(k)[0] + 1 , res);

        }

        return res;
    }


    public int findShortestSubArray1(int[] nums) {

        // 最大的数对应起始位置
        // 数组中的三个元素分别代表这个数出现的次数、这个数在原数组中第一次出现的位置和这个数在原数组中最后一次出现的位置
        Map<Integer , int[]> recordIndexMap = new HashMap<>();

        for(int x = 0 ; x < nums.length ; x ++){
            int v = nums[x];
            if(!recordIndexMap.containsKey(v)){
                recordIndexMap.put(v , new int[]{1 , x , x});
            }else{
                recordIndexMap.get(v)[0] ++;
                recordIndexMap.get(v)[2]  = x;
            }
        }

        int res = Integer.MAX_VALUE;
        int maxDu = 0;

        for(Integer key : recordIndexMap.keySet()){
            int[] records = recordIndexMap.get(key);
            // 需要找到次数最多，并且间距最小的值
            if(records[0] > maxDu){
                res = records[2] - records[1] + 1;
                maxDu = records[0];
            }else if (records[0] == maxDu){
                res = Math.min(records[2] - records[1] + 1 , res);
            }
        }

        return res;
    }


    public static void main(String[] args) {
        _697 obj = new _697();

        int[] nums = {1,2,2,3,1,4,2};

//        int[] nums = {1,2,2,3,1};

        int res = obj.findShortestSubArray1(nums);

        System.out.println(res);
    }

}
