package com.song.simple;

import java.util.Objects;

/**
 * @ClassName _21
 * @Description TODO
 * @Author szh
 * @Date 2023年08月05日
 */
public class _21 {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }


    }

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if(Objects.isNull(list1)){
            return list2;
        }else if(Objects.isNull(list2)){
            return list1;
        }else if(list1.val <= list2.val){
             list1.next = mergeTwoLists1(list1.next , list2);
            return list1;
        }else{
            list2.next = mergeTwoLists1(list1 , list2.next);
            return list2;
        }

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(Objects.isNull(list1)){
            return list2;
        }
        if(Objects.isNull(list2)){
            return list1;
        }
        ListNode dummyHead = new ListNode(-1 , null);

        ListNode prev = dummyHead;
        while (list1 != null && list2 != null){
           if(list1.val <= list2.val){
               prev.next = list1;
               list1 = list1.next;
           }else{
               prev.next = list2;
               list2  = list2.next;
           }
           prev = prev.next;
        }
        prev.next = list1 == null ? list2 : list1;
        return dummyHead.next;
    }


    public static void main(String[] args) {
        _21 obj = new _21();
        ListNode l1 = new ListNode(1 , new ListNode(2 , new ListNode(4)));
        ListNode l2 = new ListNode(1 , new ListNode(3 , new ListNode(4)));

        ListNode listNode = obj.mergeTwoLists1(l1, l2);

        System.out.println(listNode);

    }




}
