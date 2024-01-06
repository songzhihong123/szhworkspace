package com.letcode.szh.bilibili;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName IPO
 * @Description IPO 贪心
 * @Author szh
 * @Date 2024年01月05日
 */
public class IPO {


    /*
    输入：
    正数数组costs
    正数数组profits
    正数k
    正数m
    含义：
    costs[i] 表示i号项目的花费
    profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
    k表示你只能串行的最多做k个项目
    m描述出事资金
    说明：
    你每做完一个项目， 马上获得的收益，可以支持你去做下一个项目。
    输出：
    你最后获得的最大钱树
     */

    public static class Node{
        // 花费
        public int p;
        // 利润
        public int c;

        public Node(int p , int c){
            this.p = p;
            this.c = c;
        }
    }

    public static class MinCostComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }

    public static class MaxProfitComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }
    }



    public static int findMaximized(int k , int W , int[] profits , int[] capital){
        // 建立一个花费的小根堆
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        // 建立一个利润的大根堆
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());

        // 把所有的项目人到锁池中， 花费组织的小根堆
        for(int i= 0 ; i < profits.length ; i ++){
            minCostQ.add(new Node(profits[i] , capital[i]));
        }

        // 从小根堆里面找花费小于W的值，添加到利润大根堆里面
        // 再从利润大根堆里面取出一个项目来做
        // 求和得最大利润
        for(int i = 0 ; i < k ; i ++){
            while(!minCostQ.isEmpty() && minCostQ.poll().c <= W){
                maxProfitQ.add(minCostQ.poll());
            }

            if(maxProfitQ.isEmpty()){
                return W;
            }
            W += maxProfitQ.poll().p;
        }

        return W;
    }





}
