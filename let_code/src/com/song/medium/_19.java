package com.song.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Zhihong Song on 2021/4/3 17:34
 */

public class _19 {



    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0,head);
        ListNode firstNode = head;
        ListNode secondNode = dummyNode;
        for (int i = 0; i < n; i++) {
            firstNode = firstNode.next;
        }
        while (firstNode != null){
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        secondNode.next = secondNode.next.next;
        ListNode ans = dummyNode.next;
        return ans;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0,head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode curr = dummyNode;
        while (curr != null){
            stack.push(curr);
            curr = curr.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode peek = stack.peek();
        peek.next = peek.next.next;
        ListNode ans = dummyNode.next;
        return ans;
    }



    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0,head);
        int len = getLength(head);
        ListNode prev = dummyNode;
        for (int i = 1; i < len - n + 1; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return dummyNode.next;
    }

    public int getLength(ListNode head){
        int len = 0;
        while(head != null){
            len ++;
            head = head.next;
        }
        return len;
    }


    public static void main(String[] args){
        _19 obj = new _19();
        ListNode head = new ListNode(1,new ListNode(2 , new ListNode(3 , new ListNode(4 , new ListNode(5)))));
        obj.removeNthFromEnd(head,2);
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}


