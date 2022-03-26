package com.song.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Zhihong Song on 2021/3/25 9:16
 */

public class _82 {


    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyNode = new ListNode(-1,head);
        ListNode curr = dummyNode;
        while (curr.next != null && curr.next.next != null){
            if(curr.next.val == curr.next.next.val){
                int x = curr.next.val;
                while (curr.next != null && curr.next.val == x){
                    curr.next = curr.next.next;
                }
            }else{
                curr = curr.next;
            }
        }
        return dummyNode.next;
    }


    /**
     * 借助Map来实现，一样很慢
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        // 存重复的变量
        Map<Integer,Integer> initMap = new HashMap<>();
        ListNode dummyNode = new ListNode(-1 , head);
        ListNode tempNode = dummyNode;
        while (dummyNode.next != null){
            ListNode currNode = dummyNode.next;
            initMap.put(currNode.val,initMap.getOrDefault(currNode.val , 0) + 1);
            if(initMap.get(currNode.val) > 1){
                dummyNode.next = currNode.next;
            }else{
                dummyNode = dummyNode.next;
            }

        }
        ListNode resNode = tempNode;
        while (tempNode.next != null){
            ListNode currNode = tempNode.next;
            if(initMap.get(currNode.val) > 1){
                tempNode.next = currNode.next;
            }else {
                tempNode = tempNode.next;
            }
        }
        return resNode.next;
    }




    /**
     * 自己的想法，虽然执行成功了，但是效率非常一般
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        List<Integer> list = new ArrayList<>();
        ListNode dummyNode = new ListNode(-1,head);
        while (dummyNode.next != null){
            list.add(dummyNode.next.val);
            dummyNode = dummyNode.next;
        }

        List<Integer> collectList = new ArrayList<>();
        List<Integer> middleList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(collectList.contains(list.get(i)) || middleList.contains(list.get(i))){
                collectList.remove(list.get(i));
                if(!middleList.contains(list.get(i))){
                    middleList.add(list.get(i));
                }
            }else {
                collectList.add(list.get(i));
            }
        }
//        List<Integer> collectList = list.stream().distinct().collect(Collectors.toList());
        int size = collectList.size();
        if(size != 0){
            ListNode res = new ListNode(-1);
            ListNode rrr = res;
            for (int i = 0; i < size; i++) {
                ListNode temp  = new ListNode(collectList.get(i));
                res.next = temp;
                res = temp;
            }
            return rrr.next;
        }else {
            return null;
        }
    }


    public static void main(String[] agrs){
        ListNode head = new ListNode(1,new ListNode(1, new ListNode(1 , new ListNode(2, new ListNode(3)))));
        _82 obj = new _82();
        obj.deleteDuplicates1(head);
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
