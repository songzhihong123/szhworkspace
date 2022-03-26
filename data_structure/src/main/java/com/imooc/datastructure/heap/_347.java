package com.imooc.datastructure.heap;


import java.util.LinkedList;
import java.util.TreeMap;

public class _347 {


    private class Freq implements Comparable<Freq> {
        int e , freq;

        public Freq(int e , int freq){
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if(this.freq < another.freq){
                return 1;
            }else if(this.freq > another.freq){
                return -1;
            }else{
                return 0;
            }

        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        TreeMap<Integer , Integer> map = new TreeMap<>();

        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num , map.get(num) + 1);
            }else{
                map.put(num , 1);
            }
        }

        PriortyQueue<Freq> queue = new PriortyQueue<>();
        for (int key : map.keySet()){
            if(queue.getSize() < k){
                queue.enqueue(new Freq(key , map.get(key)));
            }else if (map.get(key) > queue.getFront().freq){
                queue.dequeue();
                queue.enqueue(new Freq(key , map.get(key)));
            }
        }

        LinkedList<Integer> list = new LinkedList<>();

        while (!queue.isEmpty()){
            list.add(queue.dequeue().e);
        }

        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }


}
