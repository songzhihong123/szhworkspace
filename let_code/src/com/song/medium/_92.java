package com.song.medium;

import com.song.simple._206;

import java.util.List;

/**
 * Created by Zhihong Song on 2021/3/18 10:42
 */

public class _92 {

    /**
     *  给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     */



    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummyNode = new ListNode(-1,head);

        ListNode pre = dummyNode;

        // 1. 找到left节点的第一个节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        
        //2. 找到right节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        //3. 截取需要翻转的列表
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        //4. 翻转列表
        reverseList(leftNode);

        //5. 翻转之后拼接起来
        pre.next = rightNode;
        leftNode.next = curr;


        return dummyNode.next;
    }


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


    public static void main(String[] args){
        _92 obj = new _92();

        ListNode e = new ListNode(5);
        ListNode d = new ListNode(4,e);
        ListNode c = new ListNode(3,d);
        ListNode b = new ListNode(2,c);
        ListNode head = new ListNode(1,b);

        int left = 1;
        int right = 5;

        obj.reverseBetween(head,left,right);

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

