package com.song.difficlult;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * Created by Zhihong Song on 2021/2/9 11:33
 */

public class _480 {

    public double[] medianSlidingWindow(int[] nums, int k) {
        DualHeap dh = new DualHeap(k);
        for (int i = 0; i < k; i++) {
            dh.insert(nums[i]);
        }

        double[] ans = new double[nums.length - k + 1];
        ans[0] = dh.getMedian();
        for (int i = k; i < nums.length; i++) {
            dh.insert(nums[i]);
            dh.erase(nums[i - k]);
            ans[i - k + 1] = dh.getMedian();
        }
        return ans;
    }


    class DualHeap{
        //大根堆，维护较小的一半元素
        private PriorityQueue<Integer> small;
        //小根堆，维护较大的一半元素
        private PriorityQueue<Integer> large;
        //哈希表  ，记录[延时删除]的元素，key为元素，value为需要删除的次数
        private Map<Integer,Integer> delayed;

        private int k;
        // small 和 large当前包含的元素个数，需要扣除被[延时删除]的元素
        private int smallSize, largeSize;


        public DualHeap(int k){
            this.small = new PriorityQueue<>(((o1, o2) -> o2.compareTo(o1)));
            this.large = new PriorityQueue<>(((o1, o2) -> o1.compareTo(o2)));
            this.delayed = new HashMap<>();
            this.k = k;
            this.smallSize = 0;
            this.largeSize = 0;
        }

        public double getMedian(){
            return (k & 1) == 1 ? small.peek() : ((double) small.peek() + large.peek()) / 2;
        }

        public void insert(int num){
            if(small.isEmpty() || num <= small.peek()){
                small.offer(num);
                ++smallSize;
            }else {
                large.offer(num);
                ++largeSize;
            }
            makeBalance();
        }

        public void erase(int num){
            delayed.put(num,delayed.getOrDefault(num, 0) + 1);
            if(num <= small.peek()){
                --smallSize;
                if(num == small.peek()){
                    prune(small);
                }
            }else {
                -- largeSize;
                if (num == large.peek()){
                    prune(large);
                }
            }
            makeBalance();
        }



        private void prune(PriorityQueue<Integer> heap){
            while(!heap.isEmpty()){
                int num = heap.peek();
                if (delayed.containsKey(num)){
                    delayed.put(num,delayed.get(num) - 1);
                    if(delayed.get(num) == 0){
                        delayed.remove(num);
                    }
                    heap.poll();
                }else {
                    break;
                }

            }
        }

        //调整small 和 large 中元素的个数，使得二者元素个数满足要求
        private void makeBalance(){
            // small 比 large 大两个
            if(smallSize > largeSize + 1){
                large.offer(small.poll());
                --smallSize;
                ++largeSize;
                // small 堆顶元素被移除，需要进行prune
                prune(small);
            }else if(smallSize < largeSize){
                // large 比 small 大一个
                small.offer(large.poll());
                ++smallSize;
                --largeSize;
                //large 堆顶元素被移除，需要进行prune
                prune(large);
            }
        }

    }



    public static void main(String[] args){
        _480 obj = new _480();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        Arrays.stream(obj.medianSlidingWindow(nums, k)).forEach(System.out::println);
    }

}
