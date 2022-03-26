package com.song.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Zhihong Song on 2021/1/7 13:34
 */

public class _547 {

    private int parent[];
    private int rank[]; // rank[i] 表示 节点为i的层数

    public _547(){

    }

    public _547(int size){
        parent = new int[size];
        rank = new int[size];
        for (int i = 0 ; i < size ; i ++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int getSize(){
        return parent.length;
    }

    public int find(int p){
        if(p < 0 || p > parent.length){
            throw new IllegalArgumentException("参数不合法");
        }
        while(parent[p] != p){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public boolean isConnect(int p , int q){
        return find(p) == find(q);
    }

    public void unionElements(int p , int q){
        int pNode = find(p);
        int qNode = find(q);

        if(pNode == qNode){
            return;
        }

        if(rank[pNode] > rank[qNode]){
            parent[qNode] = pNode;
        }else if(rank[pNode] < rank[qNode]){
            parent[pNode] = qNode;
        }else { //rank[pNode] = rank[qNode]
            parent[qNode] = pNode;
            rank[pNode] += 1;
        }


    }

    public int[] getData(){
        return parent;
    }




    public int findCircleNum(int[][] isConnected) {
        for (int i = 0 ; i < isConnected.length ; i ++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if(isConnected[i][j] == 1){
                    this.unionElements(i,j);
                }
            }
        }
        int[] data = this.getData();
        Arrays.stream(data).forEach(System.out::print);
        List<Integer> resultList = new ArrayList<>();
        resultList.add(find(0));
        for (int p = 1; p < data.length; p++) {
           if(!resultList.contains(find(p))){
               resultList.add(find(p));
           }
        }
        System.out.println();
        resultList.forEach(System.out::print);
        return resultList.size();
    }

    public static void main(String[] args) {
        int[][] param1 =
                {{1,1,0,0,0,0,0,1,0,1},
                 {1,1,0,0,0,0,0,0,0,0},
                 {0,0,1,0,0,0,1,0,0,0},
                 {0,0,0,1,0,0,0,0,0,0},
                 {0,0,0,0,1,0,0,0,0,0},
                 {0,0,0,0,0,1,0,0,0,0},
                 {0,0,1,0,0,0,1,1,0,0},
                 {1,0,0,0,0,0,1,1,0,0},
                 {0,0,0,0,0,0,0,0,1,1},
                 {1,0,0,0,0,0,0,0,1,1}};
        int[][] param = {{1,1,0},{1,1,0},{0,0,1}};
        _547 obj = new _547(param1.length);
        int circleNum = obj.findCircleNum(param1);
        System.out.println();
        System.out.println(circleNum);
    }

}
