package com.letcode.szh.bilibili.middle;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName Coffee
 * @Description Coffee
 * @Author szh
 * @Date 2024年01月13日
 */
public class Coffee {


    /*

     数组arr代表每一个咖啡机冲一杯咖啡的时间，每个咖啡机只能串行的制造咖啡
     现在有n个人需要喝咖啡， 只能用咖啡机来制造咖啡。
     认为每个人喝完之后的咖啡杯可以选择或者自然挥发干净，只有一台洗咖啡杯的机器，只能串行的洗咖啡杯。
     洗杯子的机器洗完一个杯子的时间为a，任何一个杯子自然挥发干净的时间为b。
     四个参数，arr , n , a , b
     假设时间点从0开始，返回所有人喝完咖啡并洗完咖啡杯的全部过程结束后，至少来到什么时间点。



    1、要先计算出来每个人可以喝咖啡的最早的时间 ， 使用一个小根堆来实现
    2、计算这个最早时间的列表，洗洗完这些杯子的最短时间


     */


    public static class Machine{
        // 咖啡机可以开始使用的时间
        public int timePoint;
        // 咖啡机工作的时间
        public int workTime;

        public Machine(int timePoint , int workTime){
            this.timePoint = timePoint;
            this.workTime = workTime;
        }

    }

    public static class MachineComparator implements Comparator<Machine>{
        @Override
        public int compare(Machine o1, Machine o2) {
            return (o1.workTime + o1.timePoint) - (o2.workTime + o2.timePoint);
        }
    }

    public static int minTime(int[] arr , int n , int a , int b){

        // 要先计算出来每个人可以喝咖啡的最早的时间 ， 使用一个小根堆来实现
        PriorityQueue<Machine> heap = new PriorityQueue<>(new MachineComparator());
        for(int i = 0 ; i < arr.length ; i ++){
            heap.add(new Machine(0 , arr[i]));
        }

        int[] drinks = new int[n];
        for(int i = 0 ; i < n ; i++ ){
            Machine poll = heap.poll();
            poll.timePoint += poll.workTime;
            drinks[i] = poll.timePoint;
            heap.add(poll);
        }

        // 2、计算这个最早时间的列表，洗洗完这些杯子的最短时间
        return process(drinks , a , b , 0 , 0);
    }

    // drinks 每个人可以喝咖啡的最早的时间列表
    // a 表示洗咖啡杯需要用的时间
    // b 表示挥发需要用的时间
    // index 表示当前位置
    // washLine 表示洗咖啡机最早可用开始时间
    // 返回洗完咖啡杯的最早时间
    public static int process(int[] drinks , int a , int b , int index , int washLine){
        if(index == drinks.length - 1){
            // Math.max(washLine , drinks[index]) + a
            // 表示 【喝完咖啡的最大时间】 和 【洗咖啡机最早可以开始的时间】 取最大值
            return Math.min( (drinks[index] + b) , Math.max(washLine , drinks[index]) + a);
        }



        // 当前咖啡杯用洗咖啡机洗的完成时间
        int wash = Math.max(washLine , drinks[index]) + a;
        int next1 = process(drinks , a , b , index + 1 , wash);
        int p1 = Math.max(wash  , next1);


        // 当前咖啡杯挥发的完成时间
        int dry = drinks[index] + b;
        int next2 = process(drinks , a , b , index + 1 , washLine);
        int p2 = Math.max(dry  , next2);

        return Math.min(p1 , p2);
    }






}
