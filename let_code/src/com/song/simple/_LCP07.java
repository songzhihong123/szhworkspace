package com.song.simple;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _LCP07 {


    // 深度优先遍历
    int ways , n , k;
    List<List<Integer>> edgs;
    public int numWays(int n, int[][] relation, int k) {
        this.n = n;
        this.k = k;
        ways = 0;
        edgs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edgs.add(new ArrayList<>());
        }
        for (int[] edge : relation) {
            int src = edge[0];
            int dst = edge[1];
            edgs.get(src).add(dst);
        }
        dfs(0,0);
        return ways;
    }
    public void dfs(int index , int step){
        if(step == k){
            if(index == n - 1){
                ways ++;
            }
            return;
        }
        List<Integer> list = edgs.get(index);
        for (Integer nextIndex : list) {
            dfs(nextIndex, step + 1);
        }
    }


    // 广度优先遍历
    public int numWays1(int n, int[][] relation, int k) {
        List<List<Integer>> edgs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edgs.add(new ArrayList<>());
        }
        for (int[] edge : relation) {
            int src = edge[0];
            int dst = edge[1];
            edgs.get(src).add(dst);
        }
        int steps = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty() && steps < k){
            steps ++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                List<Integer> list = edgs.get(index);
                for (Integer nextIndex : list) {
                    queue.offer(nextIndex);
                }
            }
        }
        int ways = 0;
        if(steps == k){
            while (!queue.isEmpty()){
                if(queue.poll() == n - 1){
                    ways ++;
                }
            }
        }
        return ways;
    }


    //动态规划
    public int numWays2(int n, int[][] relation, int k) {
        //dp[i][j] 表示经过i轮传递编号j的玩家的方案数
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] edge : relation) {
                int src = edge[0];
                int dst = edge[1];
                dp[i + 1][dst] += dp[i][src];
            }
        }
        return dp[k][n-1];
    }


    public static void main(String[] args){
        _LCP07 obj = new _LCP07();
        int n = 5;
        int[][] relation = {{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}};
        int k = 3;
        System.out.println(obj.numWays2(n , relation , k));


    }



}
