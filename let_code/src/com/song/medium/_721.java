package com.song.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Zhihong Song on 2021/1/18 8:48
 */

public class _721 {

    /**
     * 自己的解法：
     *  利用Map<String,List<String>> key 为账户的名称， value为名称对应的邮箱集合，
     *             当key重复的时候，直接将名称和账户一起放到最后的结果当中。
     * @param accounts
     * @return
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> resultList = new ArrayList<>();
        Map<String, Set<String>> resultMap = new HashMap<>();
        Boolean flag = true;
        for (int i = 0; i < accounts.size(); i++) {
            String name = accounts.get(i).get(0);
            if(resultMap.containsKey(name)){
                for (int j = 1; j < accounts.get(i).size(); j++) {
                    if(resultMap.get(name).contains(accounts.get(i).get(j))){
                        accounts.get(i).stream().forEach(str -> resultMap.get(name).add(str));
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    List<String> collect = accounts.get(i).stream().sorted().distinct().collect(Collectors.toList());
                    collect.remove(name);
                    collect.add(0,name);
                    resultList.add(collect);
                    flag = true;
                }
            }else{
                resultMap.put(name,accounts.get(i).stream().skip(1).collect(Collectors.toSet()));
            }
        }
        for (String key : resultMap.keySet()) {
            List<String> collect = resultMap.get(key).stream().sorted().collect(Collectors.toList());
            collect.remove(key);
            collect.add(0,key);
            resultList.add(collect);
        }
        return resultList;
    }

    /**
     * 官方题解，利用并查集和Hash表的方式实现。
     * @param accounts
     * @return
     */
    public List<List<String>> accountsMerge1(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<String, Integer>();
        Map<String, String> emailToName = new HashMap<String, String>();
        int emailsCount = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, emailsCount++);
                    emailToName.put(email, name);
                }
            }
        }
        UnionFind uf = new UnionFind(emailsCount);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            int size = account.size();
            for (int i = 2; i < size; i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailToIndex.get(nextEmail);
                uf.union(firstIndex, nextIndex);
            }
        }
        Map<Integer, List<String>> indexToEmails = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            int index = uf.find(emailToIndex.get(email));
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<>());
            account.add(email);
            indexToEmails.put(index, account);
        }
        List<List<String>> merged = new ArrayList<List<String>>();
        for (List<String> emails : indexToEmails.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }
        return merged;
    }


    private class UnionFind{
        int[] parent;
        int[] rank;

        public UnionFind(int size){
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        // 获取并查集的长度
        public int getSize(){
            return parent.length;
        }

        //获取下标为i的父亲下标
        public int find(int i){
            while(parent[i] != i){
                parent[i] = parent[parent[i]]; // 路劲压缩
                i = parent[i];
            }
            return i;
        }

        //判断两个下标是否连通
        public boolean isConnented(int i , int j){
            return find(i) == find(j);
        }

        //使两个下标连通
        public void union(int p , int q){
            int pRoot = find(p);
            int qRoot = find(q);

            if(pRoot == qRoot){
                return;
            }

            if(rank[qRoot] > rank[pRoot]){
                parent[pRoot] = qRoot;
            }else if(rank[pRoot] > rank[qRoot]){
                parent[qRoot] = pRoot;
            }else { //rank[pRoot] == rank[qRoot]
                parent[qRoot] = pRoot;
                rank[pRoot] += 1;
            }


        }
    }


    /**
     * [["Kevin","Kevin1@m.co","Kevin5@m.co","Kevin2@m.co"],
     * ["Bob","Bob3@m.co","Bob1@m.co","Bob2@m.co"],
     * ["Lily","Lily3@m.co","Lily2@m.co","Lily0@m.co"],
     * ["Gabe","Gabe2@m.co","Gabe0@m.co","Gabe2@m.co"],
     * ["Kevin","Kevin4@m.co","Kevin3@m.co","Kevin3@m.co"]]
     */


    public static void main(String[] args) {
        _721 obj = new _721();
        List<List<String>> accounts  = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        List<String> list4 = new ArrayList<>();
//        List<String> list5 = new ArrayList<>();

        list1.add("John");
        list1.add("johnsmith@mail.com");
        list1.add("john00@mail.com");

        list2.add("John");
        list2.add("johnnybravo@mail.com");

        list3.add("John");
        list3.add("johnsmith@mail.com");
        list3.add("john_newyork@mail.com");


        list4.add("Mary");
        list4.add("mary@mail.com");


        /*list1.add("Kevin");
        list1.add("Kevin1@m.co");
        list1.add("Kevin5@m.co");
        list1.add("Kevin2@m.co");

        list2.add("Bob");
        list2.add("Bob3@m.co");
        list2.add("Bob1@m.co");
        list2.add("Bob2@m.co");

        list3.add("Lily");
        list3.add("Lily3@m.co");
        list3.add("Lily2@m.co");
        list3.add("Lily0@m.co");


        list4.add("Gabe");
        list4.add("Gabe2@m.co");
        list4.add("Gabe0@m.co");
        list4.add("Gabe2@m.co");

        list5.add("Kevin");
        list5.add("Kevin4@m.co");
        list5.add("Kevin3@m.co");
        list5.add("Kevin3@m.co");*/

        accounts.add(list1);
        accounts.add(list2);
        accounts.add(list3);
        accounts.add(list4);
//        accounts.add(list5);

        List<List<String>> lists = obj.accountsMerge(accounts);

        for(List<String> list : lists){
            for (String str: list) {
                System.out.println(str + " ");
            }
        }

//        lists.stream().forEach(list -> list.stream().forEach(System.out::print));


    }

}
