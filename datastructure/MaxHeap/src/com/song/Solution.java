package com.song;

import java.util.Map;
import java.util.TreeMap;

/**
 * Java 中的优先队列默认是最小堆
 * 自己实现的为最大堆
 */
public class Solution {

    private class  Freq implements Comparable<Freq>{
        int e ,freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }
        @Override
        public int compareTo(Freq another) {
            //频次越低，优先级越高
            if (this.freq < another.freq){
                return 1;
            }else if(this.freq > another.freq){
                return -1;
            }else {
                return 0;
            }
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new TreeMap<Integer, Integer>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num , map.get(num) + 1);
            }else{
                map.put(num,1);
            }
        }
        PriorityQueue<Freq> pq = new PriorityQueue<Freq>();
        for(int key : map.keySet()){
            if (pq.getSize() < k){
                pq.enqueue(new Freq(key,map.get(key)));
            }else if(map.get(key) > pq.getFront().freq){
                pq.dequeue();
                pq.enqueue(new Freq(key,map.get(key)));
            }
        }
        int[] res = new int[pq.getSize()];
        for (int i = 0; i < res.length; i++) {
            res[i] = pq.dequeue().e;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] ints = new Solution().topKFrequent(nums, k);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

}
