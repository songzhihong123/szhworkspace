package com.letcode.szh.bilibili;

import java.util.PriorityQueue;

/**
 * @ClassName MiddleSum
 * @Description 中位数
 * @Author szh
 * @Date 2024年01月05日
 */
public class MiddleSum {

    /*
    一个数据流中，随时可以取得中位数
    用户源源不断的给数字，随时取到中位数
     */

    // 一个小根堆
    public static PriorityQueue<Integer> minQueue = new PriorityQueue<>();

    // 一个大根堆
    public static PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1 , o2) -> o2 - o1);


    public static void add(Integer num){

        // 判断加入的数字和大根堆的堆顶进行比较，小于大根堆的堆顶进大根堆，否则进小根堆
        if(maxQueue.isEmpty() || num <= maxQueue.peek()){
            maxQueue.add(num);
        }else{
            minQueue.add(num);
        }
        // 维护完之后，大根堆里面的所有数小于某一个数 ， 小根堆的堆顶的所有数都大于某一个数


        // 维护大根堆和小根堆的数量
        int size = maxQueue.size() - minQueue.size();
        if(size >= 2){
            minQueue.add(maxQueue.poll());
        }else if(size <= -2){
            maxQueue.add(minQueue.poll());
        }

    }

    public static int midNum(){
        if(maxQueue.isEmpty()){
            return 0;
        }
        if(!maxQueue.isEmpty() && minQueue.isEmpty()){
            return maxQueue.size() == 1 ? maxQueue.peek() : (maxQueue.poll() + maxQueue.poll()) / 2;
        }

        return (maxQueue.size() + minQueue.size()) % 2 == 0 ? (minQueue.peek() + maxQueue.peek()) / 2 : minQueue.peek();
    }


    public static void main(String[] args) {
        add(1);
//        add(2);
//        add(3);
//        add(4);
//        add(5);

        System.out.println(midNum());

    }



}
