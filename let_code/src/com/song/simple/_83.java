package com.song.simple;

import com.song.medium._82;

/**
 * Created by Zhihong Song on 2021/3/26 9:30
 */

public class _83 {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null){
            return head;
        }
        ListNode cuurNode = head;
        while(head.next != null){
            if(head.val ==  head.next.val){
                head.next = head.next.next;
            }else {
                head = head.next;
            }
        }
        return  cuurNode;
    }



    public static void main(String[] rags){
        ListNode head = new ListNode(1,new ListNode(1, new ListNode(1 , new ListNode(2, new ListNode(3)))));
        _83 obj = new _83();
        obj.deleteDuplicates(head);
    }



    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
