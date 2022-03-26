package com.song;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 *  Java 中的优先队列默认是最小堆
 */
public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new TreeMap<Integer, Integer>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num , map.get(num) + 1);
            }else{
                map.put(num,1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        for(int key : map.keySet()){
            if (pq.size() < k){
                pq.add(key);
            }else if(map.get(key) > map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }
        int[] res = new int[pq.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = pq.remove();
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
        int k = 2;
        int[] ints = new Solution().topKFrequent(nums, k);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

}
