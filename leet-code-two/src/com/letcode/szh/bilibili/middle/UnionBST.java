package com.letcode.szh.bilibili.middle;

/**
 * @ClassName UnionBST
 * @Description UnionBST
 * @Author szh
 * @Date 2024年01月11日
 */
public class UnionBST {

    /*

    给定一个非负整数n ， 代表二叉树的节点个数。
    返回能形成多少种不同的二叉树结构

     */


    // 暴力解法
    public static int process(int N){
        if(N == 0 || N == 1){
            return 1;
        }

        if(N == 2){
            return 2;
        }

        int res = 0;

        // 左树上的节点个数有0 到 N - 1 的时候
        for(int i = 0 ; i <= N - 1 ; i ++){
            // 左树节点有i个的时候有多少种方式
            int leftWay = process(i);
            // 右树节点右 N - i - 1 的时候右多少种方式 ， 减一是因为有一个节点是头节点
            int rightWay = process(N - i - 1);
            res += leftWay * rightWay;
        }

        return res;
    }



    public static int numTrees(int N){
        if(N == 0 || N == 1){
            return 1;
        }

        int[] dp =  new int[N + 1];
        dp[0] = 1;

        for(int i = 1 ; i <= N ; i ++){ // 填充dp[i] 的过程
            for(int j = 0 ; j <= i - 1 ; j ++){ // 枚举左侧节点的过程
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }


        return dp[N];
    }


    public static void main(String[] args) {
        System.out.println(process(3));
        System.out.println(numTrees(3));
    }






}
