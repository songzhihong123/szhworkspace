package com.song.medium;

import java.util.*;

/**
 * Created by Zhihong Song on 2021/1/11 16:07
 */

public class _1202 {


    public static void main(String[] args) {
//        PriorityQueue<Integer> test = new PriorityQueue<>();
//        test.offer(4);
//        test.offer(5);
//        test.offer(2);
//        test.offer(-1);
//        while(!test.isEmpty()){
//            System.out.println(test.poll());
//        }

        _1202 obj = new _1202();
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        temp.add(3);
        pairs.add(temp);
        List<Integer> temp1 = new ArrayList<>();
        temp1.add(1);
        temp1.add(2);
        pairs.add(temp1);
        System.out.println(obj.smallestStringWithSwaps(s, pairs));

    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        int len = s.length();
        UnionFind unionFind = new UnionFind(len);
        for (List<Integer> pair : pairs) {
            Integer left = pair.get(0);
            Integer right = pair.get(1);
            unionFind.unionElements(left,right);
        }

        Map<Integer, PriorityQueue<Character>> map = new HashMap<>(len);

        char[] charArray = s.toCharArray();
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
            if(map.containsKey(root)){
                map.get(root).offer(charArray[i]);
            }else {
                PriorityQueue<Character> priorityQueue = new PriorityQueue<>();
                priorityQueue.offer(charArray[i]);
                map.put(root,priorityQueue);
            }
            map.computeIfAbsent(root,key -> new PriorityQueue<>()).offer(charArray[i]);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
            builder.append(map.get(root).poll());
        }
        return builder.toString();

    }


    private class UnionFind{

        int parent[]; // 用来表示一颗数

        int rank[]; // rank[i] 表示索引为i的根节点的长度，用来做路径压缩

        public UnionFind(int len){
            parent = new int[len];
            rank = new int[len];
            for (int i = 0; i < len; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int getSize(){
            return parent.length;
        }

        // 返回索引为i的根节点
        public int find(int i){
            if(i < 0 || i > parent.length){
                throw new IllegalArgumentException("参数不合法");
            }
            while (i != parent[i]){
                //路径压缩 ，让 i 的父亲 为 i 父亲的父亲
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        //返回索引为i j 的节点是否相连
        public boolean isConnected(int i , int j){

            return find(i) == find(j);
        }

        //将索引为 i ， j 的节点相连
        public void unionElements(int i ,int j){
            int pRoot = find(i);
            int qRoot = find(j);
            if(pRoot == qRoot){
                return;
            }
            if(rank[pRoot] > rank[qRoot]){
                parent[qRoot] = pRoot;
            }else if(rank[pRoot] < rank[qRoot]){
                parent[pRoot] = qRoot;
            }else { // rank[pRoot] == rank[qRoot]
                parent[pRoot] = qRoot;
                rank[qRoot] += 1;
            }
        }
    }


}
