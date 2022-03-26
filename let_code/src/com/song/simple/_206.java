package com.song.simple;

import com.song.medium._92;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Zhihong Song on 2021/3/19 8:49
 */

public class _206 {

    // 迭代
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //递归
    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newNode = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }


    public static void main(String[] args){
        ListNode a = new ListNode(5,null);
        ListNode b = new ListNode(4,a);
        ListNode c = new ListNode(3,b);
        ListNode d = new ListNode(2,c);
        ListNode head = new ListNode(1,d);

        _206 obj = new _206();
        obj.reverseList1(head);

    }



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

}
